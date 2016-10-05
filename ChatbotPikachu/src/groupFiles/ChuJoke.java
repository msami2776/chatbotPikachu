package groupFiles;

import java.util.Random;

public class ChuJoke implements Topic {

	private boolean inJokeLoop;
	private String jokeResponse;
	private String jokes[] = {"joke1", "joke2", "joke3"};
	private int[] usedJokes = new int[10];
	private int jokeNum = 10;

	public void talk() {
		int jokeIndex = randInt(0, jokes.length);
		String joke = jokes[jokeIndex];
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


