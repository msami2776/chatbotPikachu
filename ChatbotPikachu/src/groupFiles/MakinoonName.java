package groupFiles;

import java.util.Scanner;
	//\n is space
public class MakinoonName {
	static Scanner input; 
	static String user; 
	static boolean inLoop; 
	static String response; 
	static Topic school;
	static Topic like;//example
	
	public static void main(String[] args) {
		
		createTopics();
		//characters come before
		//-1 comes before, 1 comes after
		promptName();
		talkForever(); 
 		//ap comp sci api
 	}
	public static void promptName() {
		print("Hello, human! I'm a board covered "
				+ "with semiconductors and "
				+ "other such components. "
				+ "What is your name?");
		user = input.nextLine();
		print("Awesome. I will call you " + user + 
				" until you terminate me!");
	}
	public static void talkForever(){
		inLoop = true; 
		while(inLoop){
			print("Greetings, " + user + "! How are you?");
			response = getInput(); 
			if(findKeyword(response, "good", 0) >= 0){
				print("I'm so happy that you're good");
				
			}
			else if (like.isTriggered(response) ){
				inLoop = false; 
				like.talk();
			}
			else if (findKeyword(response, "school", 0) >= 0 ){
				inLoop = false; //exit this loop 
				school.talk();
			}
			else {
				
				print("I'm sorry, I don't understand you.");
				
			}
			
		}
	}
	public static int findKeyword(String searchString, 
			String key, int startIndex) {
		//delete white space 	
		String phrase = searchString.trim(); 
		System.out.println("The trimmed phrase: " + phrase);
		//set all letters to lowercase
		phrase = phrase.toLowerCase();
		key = key.toLowerCase();
		
		System.out.println("The phrase is " + phrase);
		System.out.println("The key is " + key);
	
		int psn = phrase.indexOf(key);
		System.out.println("The psn found is " + psn);
		//keep looking for 
		while (psn >= 0){
			String before = " ";
			String after = " ";
			if (psn + key.length() < phrase.length()){
				after = phrase.substring(psn + key.length(), psn + 
						key.length()+1).toLowerCase();
				
				System.out.println("The character after " + key + "is" + after);
			}
			//if the phrase doesn't begin with this word
			if (psn > 0){
				before = phrase.substring(psn -1, psn).toLowerCase(); 
				System.out.println("The character before " + key + "is" + before);
			}
			if(before.compareTo("a") < 0 && after.compareTo("a") < 0){
				System.out.println("Key was found at " + psn);
				
				if(noNegotiations(phrase, psn)){
					return psn;
				}
				
			}
			// in case the keyword was not found yet. 
			//check thhe rest of the string 
			psn = phrase.indexOf(key, psn+1);
			System.out.println(key + " was not found." + "Checking" + psn);
		}
		return -1;
	}
	//helper method - contributes functionality to another method 
	//very common when you need to do the same thing repeatedly 
	//they also help make methods more readable 
	//this method is private bc it is only used by the method it is helping 
	
	private static boolean noNegotiations(String phrase, int index){
		//check for no 
		//check to see if there is space for the word 
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
			
		//create a multi-line string
		String printString = " " ; 
	
		int cutOff = 35; 
		//check to see if there are words to add 
		//(in other words, is length of s > 0 
		while(s.length() > 0 ){
			String currentLine = ""; 
			String nextWord = ""; 
			//while the currentline and the nextWord < cutoff and still got words to add
			while (currentLine.length() + nextWord.length() <= cutOff 
					&& s.length() > 0){
				//add the nextword to the line 
				currentLine += nextWord; 
				//remove the word 
				s = s.substring(nextWord.length());
				//get the following word 
				int endOfWord = s.indexOf(" ");
				//check if its the last wor d
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
		school = new School ();
		like = new MakinoonLike();
	}
	
}