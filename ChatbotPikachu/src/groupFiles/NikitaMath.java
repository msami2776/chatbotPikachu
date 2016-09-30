package groupFiles;

public class NikitaMath implements Topic{
	
	private boolean inMathLoop;
	private String mathResponse;

	public void talk() {
		
		inMathLoop = true;
		
		while (inMathLoop){
			
		}
	}

	public boolean isTriggered(String userInput) {
		
		String[] numbersArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		for(int i = 0; i < numbersArray.length; i++){
			if(MakinoonName.findKeyword(userInput, numbersArray[i], 0) >= 0){
				return true;
			}
		}
		return false;
	}
}
