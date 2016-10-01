package groupFiles;

public class MakinoonCostume implements Topic {
	private boolean inCostumeLoop;
	private String costumeResponse;
	private String color; //answers
	private String subject; 
	private String politicalParty; 
	private String genre; 
	private String sportCategory; 
	private Costume[] costumeList; 
	
	
	public void talk() {
		inCostumeLoop = true;
		while (inCostumeLoop){
			MakinoonName.print("Would you like me to pick a costume "
					+ "for you?");
			costumeResponse = MakinoonName.getInput();
			
			if(costumeResponse.indexOf("stop") >= 0){
				inCostumeLoop = false;
				MakinoonName.talkForever();
			}
			
			else{
				MakinoonName.print("");
			} 
			String costumeName = findCostume(); 
			
			
		}
	}
	
	private void makeCostumeList(){
		
		Costume mj = new Costume("Michael Jordan", "red", "sport", "n/a", "n/a", "basketball");
		costumeList[0] = mj; 
		Costume ronaldo = new Costume("Christiano Ronaldo", "red", "sport", "n/a", "n/a", "soccer");
		costumeList[1] = mj;
		Costume westbrook = new Costume("Russell Westbrook", "blue", "sport", "n/a", "n/a", "basketball"); 
		costumeList[2] = westbrook;
		Costume trump = new Costume("Donald Trump", "n/a", "politics", "republican", "n/a", "n/a");
		
		Costume kanye = new Costume("Kanye West", "n/a", "music", "n/a", "hip-hop", "n/a"); 
		
		Costume batman = new Costume("Batman", "black", "superheroes", "n/a", "n/a", "n/a"); 
		
	}
	private String findCostume(){
		
		Costume[] possibleCostume = new Costume[20];
		int numberOfPossibleCostumes = 0; 
		for ( int i = 0; i < costumeList.length; i++ ){
			Costume currentCostume = costumeList[i]; 
			if (currentCostume.color == color || currentCostume.color == "n/a"){ 
				if( currentCostume.subject == subject || currentCostume.subject == "n/a"){
					possibleCostume[numberOfPossibleCostumes] = currentCostume; 
					numberOfPossibleCostumes += 1; 
					
				}
			}
		}
		String chosenCostume = possibleCostume[0].name; 
		return chosenCostume ;
		
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


