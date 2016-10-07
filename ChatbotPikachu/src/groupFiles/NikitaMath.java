package groupFiles;

public class NikitaMath implements Topic{
	
	private boolean inMathLoop;
	private String mathResponse;
	private String operation;
	private int operationPsn;

	public void talk() {
		String[] operationsArray = {"+", "-", "*", "/", "<", ">", "="};
		String[] alphabetArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		
		inMathLoop = true;
		
		while (inMathLoop){
			mathResponse = MakinoonName.getInput().replaceAll("\\s", "");
			// replaceAll replaces all space characters with nothing.
			
			for(int i = 0; i < operationsArray.length; i++){
				if(MakinoonName.findKeyword(mathResponse, operationsArray[i], 0) >= 0){
					operation = operationsArray[i];
					operationPsn = MakinoonName.findKeyword(mathResponse, operation, 0);
				}
			}
			
			if(operationPsn >= 1){
				
				for(int i = 0; i < alphabetArray.length; i++){
					if(MakinoonName.findKeyword(mathResponse, alphabetArray[i], 0) >= 0){
						inMathLoop = false;
						MakinoonName.talkForever();
					}
				}
				
				int valueOne = mathResponse.charAt(operationPsn - 1) - 48;
				int valueTwo = mathResponse.charAt(operationPsn + 1) - 48;
				
				if(operation == "+"){
					System.out.println("The first value is: " + valueOne);
					System.out.println("The second value is: " + valueTwo);
					int result = valueOne + valueTwo;
					System.out.println("The answer is: " + result);
				}else{
					if(operation == "-"){
						System.out.println("The first value is: " + valueOne);
						System.out.println("The second value is: " + valueTwo);
						int result = valueOne - valueTwo;
						System.out.println("The answer is: " + result);
					}else{
						if(operation == "*"){
							System.out.println("The first value is: " + valueOne);
							System.out.println("The second value is: " + valueTwo);
							int result = valueOne * valueTwo;
							System.out.println("The answer is: " + result);
						}else{
							if(operation == "/"){
								System.out.println("The first value is: " + valueOne);
								System.out.println("The second value is: " + valueTwo);
								int result = valueOne / valueTwo;
								System.out.println("The answer is: " + result);
							}
						}
					}
				}
				
				if(operation == "=" && valueOne == valueTwo){
					System.out.println("The first value is: " + valueOne);
					System.out.println("The second value is: " + valueTwo);
					System.out.println("The answer is: true");
				}
				if(operation == "=" && valueOne != valueTwo){
					System.out.println("The first value is: " + valueOne);
					System.out.println("The second value is: " + valueTwo);
					System.out.println("The answer is: false");
				}
				
				if(operation == "<" && valueOne < valueTwo){
					System.out.println("The first value is: " + valueOne);
					System.out.println("The second value is: " + valueTwo);
					System.out.println("The answer is: true");
				}
				
				if(operation == "<" && valueOne > valueTwo){
					System.out.println("The first value is: " + valueOne);
					System.out.println("The second value is: " + valueTwo);
					System.out.println("The answer is: false");
				}
				
				if(operation == "<" && valueOne == valueTwo){
					System.out.println("The first value is: " + valueOne);
					System.out.println("The second value is: " + valueTwo);
					System.out.println("The answer is: false");
				}
				
				if(operation == ">" && valueOne > valueTwo){
					System.out.println("The first value is: " + valueOne);
					System.out.println("The second value is: " + valueTwo);
					System.out.println("The answer is: true");
				}
				
				if(operation == ">" && valueOne < valueTwo){
					System.out.println("The first value is: " + valueOne);
					System.out.println("The second value is: " + valueTwo);
					System.out.println("The answer is: false");
				}
				
				if(operation == ">" && valueOne == valueTwo){
					System.out.println("The first value is: " + valueOne);
					System.out.println("The second value is: " + valueTwo);
					System.out.println("The answer is: false");
				}
				
			}else{
				MakinoonName.print("That's not a math equation! Try again or stop?");
			}
			
			if(mathResponse.indexOf("stop") >= 0){
				inMathLoop = false;
				MakinoonName.talkForever();
			}
			
			if(mathResponse.indexOf("nevermind") >= 0){
				inMathLoop = false;
				MakinoonName.talkForever();
			}
		}
	}

	public boolean isTriggered(String userInput) {
		
		String[] triggerArray = {"solve", "math", "equal", "boolean"};
		
		for(int i = 0; i < triggerArray.length; i++){
			if(MakinoonName.findKeyword(userInput, triggerArray[i], 0) >= 0){
				System.out.println("I can solve something with whole numbers for you! Try me!");
				return true;
			}
		}
		return false;
	}
}
