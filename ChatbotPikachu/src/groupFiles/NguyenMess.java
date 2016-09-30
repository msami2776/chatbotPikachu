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
