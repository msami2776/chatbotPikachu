/*
package groupFiles;


public class NguyenMess implements Topic {
	
	private boolean inMessLoop;
	private String messResponse;

	public void talk() {
		inMessLoop = true;
		while (inMessLoop){
			MakinoonName.print("Tell me about school.");
			messResponse = MakinoonName.getInput();
			if(messResponse.indexOf("stop") >= 0){
				inMessLoop = false;
				MakinoonName.talkForever();
			}
			else{
				MakinoonName.print("That's my favorite " + "part about school too.");
			}
		}
	}

	public boolean isTriggered(String userInput) {
		if(MakinoonName.findKeyword(userInput, "homework", 0) >= 0){
			return true;
		}
		if(MakinoonName.findKeyword(userInput, "class", 0) >= 0){
			return true;
		}
		return false;
	}
}
*/
//gives the Chatbot an atitude
package groupFiles;
import java.util.Random;
public class NguyenMess implements Topic {
	
	//private boolean inMessLoop;
	//private String messResponse;
	private int shutUpCount = 0;
	private String repeatedResponse;
	private String whichResponse;//checks the response to see how to reply
	
	
	private String messResponse;
	private int responseLength;
	private int lastCharacter;
	
	String[] shutUpResponseArray = {"HEY! You can't tell me what to do.", "Or what?", "Don't boss me!","Why so rude?!"}; 
	String[] questionResponseArray = {"Do I have to answer that question?", "Can I not answer that question?", "Do I HAVE to answer?"}; 
	 
	

	public void talk() {
		if(whichResponse == "1")
		{
			shutUpCount++;
			MakinoonName.print(shutUpResponseArray[randomNumberRange(4)]);
		}
		if(whichResponse == "2")
		{
			if(shutUpCount <= 0)
			{
				MakinoonName.print("I might be programmed to be a ghost, but I'm actually a program.  No need to say sorry.");
			}
			if(shutUpCount == 1)
			{
				MakinoonName.print("It's ok.");
			}
			if(shutUpCount > 1)
			{
				MakinoonName.print("Are you sure about that? You just told be to shut up "+shutUpCount+" times!");
			}			
		}
		if(whichResponse == "3")
		{
			MakinoonName.print(questionResponseArray[randomNumberRange(3)]);
		}
		//System.out.println(messResponse);
		//System.out.println(responseLength);
		//System.out.println(lastCharacter);
		
		MakinoonName.talkForever();
		
		
		
			
//			inMessLoop = true;
//			while (inMessLoop){
//				MakinoonName.print("I don't really feel like answering.");
//				messResponse = MakinoonName.getInput();
//				if(messResponse.indexOf("stop") >= 0){
//					inMessLoop = false;
//					MakinoonName.talkForever();
//				}
//				else{
//					MakinoonName.print("That's my favorite " + "part about school too.");
//				}
//			}
		
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
		responseLength = userInput.length();
		if(MakinoonName.findKeyword(userInput, "shut up", 0) >= 0 || MakinoonName.findKeyword(userInput, "be quiet", 0) >= 0){
			whichResponse = "1";
			return true;
		}
		else if(messResponse.indexOf("?")>-1){
			whichResponse = "3";
			return true;
		}
		if(MakinoonName.findKeyword(userInput, "sorry", 0) >= 0 || MakinoonName.findKeyword(userInput, "i didn't mean it", 0) >= 0){
			whichResponse = "2";
			return true;
		}
		return false;
	}
}
