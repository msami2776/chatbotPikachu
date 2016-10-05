package groupFiles;

import java.util.Random;

public class ChuJoke implements Topic {

	private boolean inJokeLoop;
	private String jokeResponse;
	private String jokes[] = {"joke1", "joke2", "joke3"};//add jokes later
	private String usedJokes[] = {"", "", ""}; //add used jokes to here. once array is full, have computer look for full array and say "no more jokes"
	private int jokeNum = 10; //only 10 jokes

	public void talk() {
		int jokeIndex = randInt(0, jokes.length);
		String joke = jokes[jokeIndex];
		if(usedJokes[9] == jokes[0]){
			System.out.println("I don't want to tell you any more jokes");
			MakinoonName.talkForever();
		}
		inJokeLoop = true;
		while (inJokeLoop){
			MakinoonName.print("Oh, you wanna hear a joke?");
			jokeResponse = MakinoonName.getInput();
			if(jokeResponse.indexOf("stop") >= 0){
				inJokeLoop = false;
				MakinoonName.talkForever();
			}
			else{
				MakinoonName.print("I'll take that as a yes.");
			}
		}
	}
	
	public static int randInt(int min, int max) {
		Random gen = new Random();
	    int randomNum = gen.nextInt((max - min) + 1) + min;

	    return randomNum;
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
		return false;
	}
}


