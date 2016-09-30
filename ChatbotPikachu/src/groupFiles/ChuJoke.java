package groupFiles;

public class ChuJoke implements Topic {

	private boolean inJokeLoop;
	private String jokeResponse;

	public void talk() {
		inJokeLoop = true;
		while (inJokeLoop){
			MakinoonName.print("How about a joke?");
			jokeResponse = MakinoonName.getInput();
			if(jokeResponse.indexOf("stop") >= 0){
				inJokeLoop = false;
				MakinoonName.talkForever();
			}
			else{
				MakinoonName.print("");
			}
		}
	}

	public boolean isTriggered(String userInput) {
		if(MakinoonName.findKeyword(userInput, "", 0) >= 0){
			return true;
		}
		if(MakinoonName.findKeyword(userInput, "", 0) >= 0){
			return true;
		}
		return false;
	}
}


