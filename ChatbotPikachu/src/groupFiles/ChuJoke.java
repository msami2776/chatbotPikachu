package groupFiles;

public class ChuJoke implements Topic {

	private boolean inSchoolLoop;
	private String schoolResponse;

	public void talk() {
		inSchoolLoop = true;
		while (inSchoolLoop){
			MakinoonName.print("Tell me about school.");
			schoolResponse = MakinoonName.getInput();
			if(schoolResponse.indexOf("stop") >= 0){
				inSchoolLoop = false;
				MakinoonName.talkForever();
			}
			else{
				MakinoonName.print("That's my favorite " + "part about school too.");
			}
		}
	}

	public boolean isTriggered(String userInput) {
		if(MakinoonName.findKeyword(userInput, "school", 0) >= 0){
			return true;
		}
		if(MakinoonName.findKeyword(userInput, "class", 0) >= 0){
			return true;
		}
		return false;
	}
}


