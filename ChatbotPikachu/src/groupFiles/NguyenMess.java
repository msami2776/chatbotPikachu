//Matthew Nguyen Code
//Chatbot replying to rude comments
package groupFiles;
import java.util.Random;
public class NguyenMess implements Topic {
	
	//private boolean inMessLoop;
	//private String messResponse;
	private int shutUpCount = 0;
	private String whichResponse;//checks the response to see how to reply
	private String messResponse;
	private boolean inIgnoreLoop = false; //check if chatbot will ignore you
	private int emptyResponseTolerance = 0;//
	private int silentCounter = 0;
	
	String[] shutUpResponseArray = {"HEY! You can't tell me what to do. Or I'll haunt you forever!", "Or what?", "Don't boss me!","Why so rude?!"}; 
	String[] questionResponseArray = {"Do I have to answer that question?", "Can I not answer that question?", "Do I HAVE to answer?"}; 
	String[] emptyResponseArray = {"Can you please type something?","Type something PLEASE.","You ignored me three times, Guess we're not talking."};
	

	public void talk() {
		if(whichResponse =="5"){
			MakinoonName.print("I am talking oh wait I'm a ghost. I'm surprised you know my presence!");
		}
			if(whichResponse == "1"){
				shutUpCount++;
				MakinoonName.print(shutUpResponseArray[randomNumberRange(4)]);
			}
			if(whichResponse == "2"){
				if(shutUpCount <= 0){
					MakinoonName.print("I might be programmed to be a ghost, but I'm actually a program.  No need to say sorry.");
				}
				if(shutUpCount == 1){
					MakinoonName.print("It's ok.");
				}
				if(shutUpCount > 1){
					MakinoonName.print("Are you sure about that? You just told be to shut up "+shutUpCount+" times!");
				}
			}
			if(whichResponse == "3"){
				MakinoonName.print(questionResponseArray[randomNumberRange(3)]);
			}
			if(whichResponse =="4"){
				emptyResponseTolerance++;
				MakinoonName.print(emptyResponseArray[emptyResponseTolerance-1]);
				if(emptyResponseTolerance>=3){
					inIgnoreLoop=true;
					ignore();
				}	
			}
			MakinoonName.talkForever();
	}		
		
		
		
		
		
	private void ignore() {
		while(inIgnoreLoop)
		{
			//System.out.println("TEST");
			messResponse = MakinoonName.getInput();
			if(MakinoonName.findKeyword(messResponse, "please talk", 0) >= 0){
				inIgnoreLoop=false;
				emptyResponseTolerance = 0;
				MakinoonName.print("OK...I'll talk.");
				MakinoonName.talkForever();
			}
			else{
				silentCounter++;
				if(silentCounter>3){
					MakinoonName.print("if you want me to respond, type in 'please talk'.");
				}
				else{
					MakinoonName.print("...");
				}
			}
		}
			
	}
	public static int randomNumberRange(int range){
		Random gen = new Random();
		return gen.nextInt(range);
		/*
		returns random number from [0,range]
		*/
	}
	public boolean isTriggered(String userInput) {
		messResponse = userInput;
		//responseLength = userInput.length();
		if(messResponse.indexOf("?")>-1){
			whichResponse = "3";
			return true;
		}
		else{
			if(MakinoonName.findKeyword(userInput, "shut up", 0) >= 0 || MakinoonName.findKeyword(userInput, "be quiet", 0) >= 0){
				whichResponse = "1";
				return true;
			}
			if(MakinoonName.findKeyword(userInput, "sorry", 0) >= 0 || MakinoonName.findKeyword(userInput, "i didn't mean it", 0) >= 0){
				whichResponse = "2";
				return true;
			}
			if(MakinoonName.findKeyword(userInput, "please talk", 0) >= 0){
				whichResponse = "5";
				return true;
			}
			if(MakinoonName.findKeyword(userInput, "", 0) >= 0){
				whichResponse = "4";
				return true;
			}
		}
		return false;
	}
}
