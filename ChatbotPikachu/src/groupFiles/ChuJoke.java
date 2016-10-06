package groupFiles;

import java.util.Random;

public class ChuJoke implements Topic {

	private boolean inJokeLoop;
	private boolean knockLoop;
	private int messCount = -1;
	private int jokeNum = 0;
	private String jokeResponse;
	private String jokeWord[] = {"joke1", "joke2", "joke3"};//add jokes later
	private String jokePhrase[] = {"joke1", "joke2", "joke3"};
	private String calmWrongResponse[] = {"That's not how the joke goes!","Come on, I thought you wanted to hear a joke!","Ugh, let's try this again from the top"};
	private String angryWrongResponse[] = {"You're supposed to be following along with the joke! Let's try that again","Seriously?","Why do I bother..."};
	private String dejectedResponse[] = {"Oh, okay then...","I didn't think my jokes were that bad.","Maybe some other time"};
	
	public static int randInt(int min, int max) {
		Random gen = new Random();
		int randomNum = gen.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public void talk() {
		inJokeLoop = true;
		knockLoop = true;
		while (inJokeLoop){
			MakinoonName.print("Oh, you wanna hear a joke?");
			jokeResponse = MakinoonName.getInput();
			if(jokeResponse.indexOf("stop") >= 0){
				inJokeLoop = false;
				MakinoonName.talkForever();
			}
			if(jokeResponse.indexOf("no") >= 0){
				inJokeLoop = false;
				MakinoonName.talkForever();
			}
			if(jokeResponse.indexOf("nope") >= 0){
				inJokeLoop = false;
				MakinoonName.talkForever();
			}
			if(jokeResponse.indexOf("mothballs") >= 0){
				inJokeLoop = false;
				MakinoonName.print("Such an interesting word, isn't it?");
				MakinoonName.talkForever();
			}
			else{
				MakinoonName.print("I'll take that as a yes!");
				for(int i = 0; i < jokeWord.length; i++){
					while(knockLoop){
						messCount++;
						MakinoonName.print("Knock-knock.");
						jokeResponse = MakinoonName.getInput();
						if(jokeResponse.indexOf("there") >= 0){
							MakinoonName.print(jokeWord[jokeNum]);
						}
						else{
							printResponse();
						}
						jokeResponse = MakinoonName.getInput();
						if(jokeResponse.indexOf("who") >= 0){
							MakinoonName.print(jokePhrase[jokeNum]);
							knockLoop = false;
						}
						else{
							printResponse();
						}
					}
					jokeNum++;
					MakinoonName.print("Do you want to hear another joke?");
					jokeResponse = MakinoonName.getInput();
					if(jokeResponse.indexOf("no") >= 0){
						MakinoonName.print(dejectedResponse[randInt(0,dejectedResponse.length)]);
						MakinoonName.talkForever();
					}
					if(jokeResponse.indexOf("nope") >= 0){
						MakinoonName.print(dejectedResponse[randInt(0,dejectedResponse.length)]);
						MakinoonName.talkForever();
					}
					else{
						knockLoop = true;
					}
				}
			}
		}
	}
	
	private void printResponse() {
		int responseIndex = 0;
		if(messCount >= 5){
			responseIndex = (int)(Math.random() * calmWrongResponse.length);
			MakinoonName.print(calmWrongResponse[responseIndex]);
		}
		else{
			responseIndex = (int)(Math.random() * angryWrongResponse.length);
			MakinoonName.print(angryWrongResponse[responseIndex]);
		}
	}

	public boolean isTriggered(String userInput) {
		if(MakinoonName.findKeyword(userInput, "joke", 0) >= 0){
			return true;
		}
		if(MakinoonName.findKeyword(userInput, "bored", 0) >= 0){
			return true;
		}
		if(MakinoonName.findKeyword(userInput, "boring", 0) >= 0){
			return true;
		}
		if(MakinoonName.findKeyword(userInput, "mothballs", 0) >= 0){
			return true;
		}
		return false;
	}
}


