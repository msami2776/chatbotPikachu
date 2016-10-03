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
			
			else {
				
				MakinoonName.print("What's your favorite color?");
				color = costumeResponse;
				MakinoonName.print("What category would you like: politics/music/sports?");
				subject = costumeResponse;
				
			} 
			String costumeName = findCostume(); 
			
			
		}
	}
	
	private void makeCostumeList(){
		//politics - categorized by political party 
		Costume trump = new Costume("Donald Trump", "n/a", "politics", "Republican", "n/a", "n/a");
		costumeList[0] = trump;
		Costume hillary = new Costume("Hillary Clinton", "n/a", "politics", "Democrat", "n/a", "n/a");
		costumeList[1] = trump;
		//Sports - categorized by jersey colors 
		Costume mj = new Costume("Michael Jordan", "red", "sport", "n/a", "n/a", "basketball");
		costumeList[2] = mj;
		Costume ronaldo = new Costume("Christiano Ronaldo", "red", "sport", "n/a", "n/a", "soccer");
		costumeList[3] = ronaldo;
		
		Costume westbrook = new Costume("Russell Westbrook", "blue", "sport", "n/a", "n/a", "basketball"); 
		costumeList[4] = westbrook;
		Costume messi = new Costume("Lionel Messi", "blue", "sport", "n/a", "n/a", "soccer");
		costumeList[5] = messi;
		
		Costume garnett = new Costume("Kevin Garnett", "green", "sport", "n/a", "n/a", "basketball"); 
		costumeList[6] = garnett;
		Costume howard = new Costume("Tim Howard", "green", "sport", "n/a", "n/a", "soccer"); 
		costumeList[7] = howard;
		
		Costume bosh = new Costume("Chris Bosh", "black", "sport", "n/a", "n/a", "basketball"); 
		costumeList[8] = bosh;
		Costume bale = new Costume("Gareth Bale", "black", "sport", "n/a", "n/a", "soccer"); 
		costumeList[9] = bale;
		
		//music - categorized by genre
		Costume kanye = new Costume("Kanye West", "n/a", "music", "n/a", "hip-hop", "n/a"); 
		costumeList[10] = kanye; 
		Costume tupac = new Costume("Tupac Shakur", "n/a", "music", "n/a", "rap", "n/a"); 
		costumeList[11] = tupac;
		Costume taylor = new Costume("Taylor Swift", "n/a", "music", "n/a", "pop", "n/a"); 
		costumeList[12] = taylor;
		
		//Superheroes -catergorized by color also
		Costume batman = new Costume("Batman", "black", "superhero", "n/a", "n/a", "n/a"); 
		costumeList[13] = batman;
		Costume flash = new Costume("The Flash", "red", "superhero", "n/a", "n/a", "n/a"); 
		costumeList[14] = flash;
		Costume captain = new Costume("Captain America", "blue", "superhero", "n/a", "n/a", "n/a"); 
		costumeList[15] = captain;
		Costume lantern = new Costume("Green Lantern", "green", "superhero", "n/a", "n/a", "n/a"); 
		costumeList[16] = lantern; 
		
		 
	}
	private String findCostume(){
		
		Costume[] possibleCostume = new Costume[16];
		int numberOfPossibleCostumes = 0; 
		for ( int i = 0; i < costumeList.length; i++ ){
			Costume currentCostume = costumeList[i]; 
			if (currentCostume.color == color || currentCostume.color == "n/a"){ 
				if( currentCostume.subject == subject || currentCostume.subject == "n/a"){
					if( currentCostume.politicalParty == politicalParty || currentCostume.politicalParty == "n/a"){
						if( currentCostume.genre == genre || currentCostume.genre == "n/a"){
							if( currentCostume.sportCategory == sportCategory || currentCostume.sportCategory == "n/a"){
								possibleCostume[numberOfPossibleCostumes] = currentCostume; 
								numberOfPossibleCostumes += 1; 
							}
						}
					}
						
					
				}
			}
		}
		String chosenCostume = possibleCostume[0].name; 
		return chosenCostume ;
		
	}
	public boolean isTriggered(String userInput) {
		if(MakinoonName.findKeyword(userInput, "costume", 0) >= 0){
			return true;
		}
		if(MakinoonName.findKeyword(userInput, "outfit", 0) >= 0){
			return true;
		}
		return false;
	}
}


