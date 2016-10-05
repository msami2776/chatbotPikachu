package groupFiles;

public class NikitaMath implements Topic{
	
	private boolean inMathLoop;
	private String mathResponse;
	private String mathResponse2;
	private String operation;
	private String operationPsn;

	public void talk() {
		System.out.println("TALK STARTED");
		String[] operationsArray = {"+", "-", "*", "/", "<", ">", "%"};
		
		inMathLoop = true;
		
		while (inMathLoop){
			mathResponse = MakinoonName.getInput();
			
			if(MakinoonName.findKeyword(mathResponse, "yes", 0) >= 0){
				System.out.println("Okay! Throw an equation at me.");
				mathResponse2 = MakinoonName.getInput();
				for(int i = 0; i < operationsArray.length; i++){
					if(MakinoonName.findKeyword(mathResponse2, operationsArray[i], 0) >= 0){
						int operationPsn = MakinoonName.findKeyword(mathResponse2, "yes", 0);
					}
				}
			}
			
			if(operationPsn >= 0){
				String valueOne = mathResponse.substring(operationPsn - 2);
				System.out.println("The first value is: " + valueOne);
				String valueTwo = mathResponse.substring(operationPsn + 2);
				System.out.println("The second value is: " + valueTwo);
				String result = valueOne + " " + operation + " " + valueTwo;
				MakinoonName.print(result);
				
			}else{
				MakinoonName.print("I don't understand you");
			}
			
		}
	}

	public boolean isTriggered(String userInput) {
		
		String[] triggerArray = {"solve", "math", "equal", "boolean"};
		
		for(int i = 0; i < triggerArray.length; i++){
			if(MakinoonName.findKeyword(userInput, triggerArray[i], 0) >= 0){
				System.out.println("Do you want me to solve something?");
				return true;
			}
		}
		return false;
	}
}
