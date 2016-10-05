package groupFiles;

public class MakinoonCostume implements Topic {
	private boolean inCostumeLoop;
	private String costumeResponse;
	private String color; //answers
	private String subject; 
	private String politicalParty; 
	private String genre; 
	private String sportCategory; 
	private Costume[] costumeList = new Costume[17]; 
	private String[] positiveAnswers = {"yes", "of course", "sure"};//create answers 
	private String[] colors = {"red", "blue", "green", "black"};
	private String[] subjects = {"politics", "sport", "music"};
	private String[] politicParty = {"democrat", "republican"};
	private String[] genres = {"hip-hop", "rap", "pop"}; 
	private String[] sportsCategory = {"baskbetball", "soccer"}; 
	
	public void talk() {
		
			makeCostumeList(); 
		
		inCostumeLoop = true;
		
		while (inCostumeLoop){
			MakinoonName.print("Would you like me to pick a costume "
					+ "for you?");
			costumeResponse = MakinoonName.getInput();
			
			boolean containsPositive = false; 
			
			for(int k = 0; k < positiveAnswers.length; k++){
				
	
				/*Negative answers
				 * checking keywords and matching it with the proper category
				 */
				
				
				if(MakinoonName.findKeyword(costumeResponse, positiveAnswers[k], 0) >= 0){
					containsPositive = true; 
					MakinoonName.print("What's your favorite color?");
					String response =  getResponse(MakinoonName.getInput(), colors);
					color = response; 
					System.out.println(color);
					
					MakinoonName.print("What category would you like: politics/music/sport?");
					subject = MakinoonName.getInput();
						if(subject.equals("politics")){
							MakinoonName.print("What party do you prefer: democrat or republican?");
							politicalParty = MakinoonName.getInput().toLowerCase();
							String costumeName = findCostume();
							MakinoonName.print("The ideal costume for you is " + costumeName + "!");
						}
						if (subject.equals("sport")){
							MakinoonName.print("Do you prefer soccer or basketball?"); 
							sportCategory = MakinoonName.getInput().toLowerCase();
							String costumeName = findCostume();
							MakinoonName.print("The ideal costume for you is " + costumeName + "!");
						}
						if(subject.equals("music")){
							MakinoonName.print("Do you prefer hip-hip, rap or pop?"); 
							genre = MakinoonName.getInput().toLowerCase();
							String costumeName = findCostume();
							MakinoonName.print("The ideal costume for you is " + costumeName + "!");
							
						}
						if(subject.equals("none")){
							MakinoonName.print("Can I pick a superhero for you?");
							if(MakinoonName.getInput().toLowerCase().equals("no")){
								inCostumeLoop = false; 
								MakinoonName.talkForever();
								
							}
							if(MakinoonName.getInput().toLowerCase().equals("yes")){
								subject = "superhero";
								String costumeName = findCostume();
								MakinoonName.print("The ideal costume for you is " + costumeName + "!");
							}
						}else{
							inCostumeLoop = false; 
						MakinoonName.talkForever();
						}
						
				}
				
			}
			if (containsPositive == false ){
				inCostumeLoop = false;
				MakinoonName.talkForever();
			}
			
			
			
			
		}
	}
	
	public String getResponse(String input, String[] anyArray){
		String inputSelected = "";
		boolean coninuing = true;
		while(coninuing){
			String options = "";
			//check if the input is any color
			for(int i = 0; i < anyArray.length; i++){
				options += anyArray[i] + " ";
				
				if(MakinoonName.findKeyword(input, anyArray[i], 0) >=0){
					inputSelected = anyArray[i];
					return inputSelected; //ends method
				}	
			}
			if(MakinoonName.findKeyword(input, "stop", 0) >= 0){
				coninuing = false;
				MakinoonName.talkForever();
			}else{
				MakinoonName.print("sorry, I can only match "+ options
						+ "Please enter something else");
				
				input = MakinoonName.getInput();
				
			}
		}
		return "stop";
	}
	
	private void makeCostumeList(){
		//politics - categorized by political party 
		Costume trump = new Costume("Donald Trump", "n/a", "politics", "depublican", "n/a", "n/a");
		costumeList[0] = trump;
		Costume hillary = new Costume("Hillary Clinton", "n/a", "politics", "democrat", "n/a", "n/a");
		costumeList[1] = hillary;
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
		
		Costume[] possibleCostume = new Costume[17];
		int numberOfPossibleCostumes = 0; 
		for ( int i = 0; i < costumeList.length; i++ ){
			Costume currentCostume = costumeList[i]; 
			if (currentCostume.color.equals(color) || currentCostume.color.equals("n/a")) { 
				if( currentCostume.subject.equals(subject) || currentCostume.subject.equals("n/a")){
					if( currentCostume.politicalParty.equals(politicalParty) || currentCostume.politicalParty.equals("n/a")){
						if( currentCostume.genre.equals(genre) || currentCostume.genre.equals("n/a")){
							if( currentCostume.sportCategory.equals(sportCategory) || currentCostume.sportCategory.equals("n/a")){
								possibleCostume[numberOfPossibleCostumes] = currentCostume; 
								numberOfPossibleCostumes += 1; 
							}
						}
					}
						
					
				}
			}
		}
		if(numberOfPossibleCostumes == 0 ){
			System.out.println("Sorry I couldn't find your custom");
			MakinoonName.talkForever();
			
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


