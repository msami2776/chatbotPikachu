package groupFiles;

import java.util.Scanner;

public class MakinoonName {
	static Scanner input; 
	static String user; 
	static boolean inLoop; 
	static String response; 
	static Topic math;
	static Topic mess;
	static Topic joke;
	static Topic costume; 

	public static void main(String[] args) {

		createTopics();
		promptName();
		talkForever(); 
	}
	public static void promptName() {
		print("Welcome. I'm your Halloween Ghost.\n"
				+ "What is your name?");
		user = input.nextLine();
		print("Fine, I will call you " + user + 
				" until you press the red button!");
	}
	public static void talkForever(){
		inLoop = true; 
		while(inLoop){
			print(user + ", I can pick a halloween costume, help you with a last minute Math homework or tell you a joke. "
					+ "What would you like?");
			response = getInput(); 
			if(findKeyword(response, "nothing", 0) >= 0){
				print("Alright, I'll be here haunting your dreams.");

			}
			else if (costume.isTriggered(response)){
				inLoop = false; 
				print("triggered costume");
				costume.talk(); 
			}

						else if (mess.isTriggered(response)){
							inLoop = false; 
							print("triggered mess");
							mess.talk();
						}
			else if (math.isTriggered(response)){
				inLoop = false; 
				print("triggered math");
				math.talk();
			}
			else if (joke.isTriggered(response)){
				inLoop = false; 
				print("triggered joke");
				joke.talk(); 
			}
			else {

				print("I don't understand you, try again.");

			}

			
		}
	}

	public static int findKeyword(String searchString, 
			String key, int startIndex) {

		if(key.equals("") && searchString.equals("")){
			return 0;
		}else if (key.equals("")){
			return -1;
		}
			
		
		String phrase = searchString.trim(); 

		phrase = phrase.toLowerCase();

		key = key.toLowerCase();

		int psn = phrase.indexOf(key);

		while (psn >= 0){
			String before = " ";
			String after = " ";
			if (psn + key.length() < phrase.length()){
				after = phrase.substring(psn + key.length(), psn + 
					key.length()+1).toLowerCase();

			}

			if (psn > 0){
				before = phrase.substring(psn -1, psn).toLowerCase(); 
			
			}
			if(before.compareTo("a") < 0 && after.compareTo("a") < 0){
//			
				if(noNegotiations(phrase, psn)){
					return psn;
				}

			}
			
				psn = phrase.indexOf(key, psn+1);
		}
		return -1;
	}
	//this method is private bc it is only used by the method it is helping 

	private static boolean noNegotiations(String phrase, int index){
		
		if(index - 3 >= 0 
				&& phrase.substring(index - 3, index ).equals("no ")){
			return false; 
		}
		if(index - 4 >= 0 
				&& phrase.substring(index - 4, index ).equals("not ")){
			return false; 
		}
		if(index - 6 >= 0 
				&& phrase.substring(index - 6, index ).equals("no ")){
			return false; 
		}
		if(index - 4 >= 0 
				&& phrase.substring(index - 4, index ).equals("n't ")){
			return false; 
		}
		return true;

	}
	public static void promptInput() {
		print(user + ", try inputting a String!");
		String userInput = input.nextLine();
		print("You typed: " + userInput);
	}
	public static String getInput(){
		return input.nextLine();
	}
	public static void print(String s) {
 
		String printString = "" ; 

		int cutOff = 65; 
		
		while(s.length() > 0 ){
			String currentLine = ""; 
			String nextWord = ""; 
			
			while (currentLine.length() + nextWord.length() <= cutOff 
					&& s.length() > 0){
				
				currentLine += nextWord; 
				
				s = s.substring(nextWord.length());
				
				int endOfWord = s.indexOf(" ");
				
				if(endOfWord < 0){
					endOfWord = s.length() -1; 
				}
				nextWord = s.substring(0, endOfWord +1);
			}
			printString += currentLine + "\n";
		}
		System.out.println(printString);

	}
	public static void createTopics() {

		input = new Scanner(System.in);
		math = new NikitaMath();
		mess = new NguyenMess();
		joke = new ChuJoke();
		costume = new MakinoonCostume(); 
	}

}
