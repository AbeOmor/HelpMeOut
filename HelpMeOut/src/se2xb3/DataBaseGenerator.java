package se2xb3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// Generates a sample database
public class DataBaseGenerator {
	
	private final int DATA_SIZE = 10000;
	HMOProfile[] testProfiles;
	
	RedBlackBST<String,String> studNumBST;
	RedBlackBST<String,String> phoneBST;
	
	// Generator draws from these arrays randomly
	String[] emailSuffix = {"@yahoo","@hotmail","@gmail","@mcmaster"};
	String[] names = {"Jay","Abe", "Genevieve","Sumail","Doto","Arteezy","Jordan","Girl1","Rebecca",
			"Emily", "Jessica", "Meh","LOL","Bwah","Magnus","Gummy","Vitamin","Happy","Multi"
			,"Vacuum","Pho","Rang","Ware","Plane","Sad","Pickle","Bob","Patrick","Squid","Lion",
			"Bird","Man","Rick","Roll","Mega","Pan","Fry","Cup","Key","Fred","Freddie","Ripperino"
			, "Pepperino","Gucci","Salty","Fish","Salt","Pepper","Iron","Murica","Ven","Paper","Vino",
			"Ohi","Sunny","Computer","YOLO","Swaggins","Frodo","Baggins","Boromir","Sam","Samwise","Gamgam"};
	
	String[] talents = {"Sports","Education","Foods","Arts","Handy Man","IT Guy","Fashion/Style"};
	
	String[] sportComments = {"VolleyBall","Basketball","Soccer","Rowing","Hockey","Tennis","Bowling"};
	String[] educationComments = {"Physics","Math","Biology","Computer Science","Calculus","Music","Gym"};
	String[] foodComments = {"Western","Indian","Scandanavian","Russian","Peruvian","Vietnamese","Asian"};
	String[] artComments = {"Painting","Oil","Music","Piano","Sketching","Photography","Modelling"};
	String[] handyManComments = {"Plumbing","Fix","Gardening","Hose","Garage","Door"};
	String[] itComments = {"Electrician","Circuits","Coding","Mac","PC","Computer","Embedded Systems"};
	String[] fashionComments = {"Hair","Clothing","Make-up","Swag"};
	
	int studentNum;
	String firstName;
	String lastName;
	String email;
	long phone;
	double price;
	String talent;
	String comment;
	
	
	
	DataBaseGenerator(){
		testProfiles = new HMOProfile[DATA_SIZE];
		studNumBST = new RedBlackBST<String,String>();
		phoneBST = new RedBlackBST<String,String>();
		
		Writer wr = null;
	    File f = new File("src/se2xb3/testdatabase.csv");
	    try {
	    	wr = new BufferedWriter(new FileWriter(f));
	    	for (int i = 0; i < DATA_SIZE;i++){
	    		studentNum = generateStudentNumber();
	    		firstName = generateFirstName();
	    		lastName = generateLastName();
	    		email = generateEmail();
	    		phone = generatePhone();
	    		talent = generateTalent();
	    		comment = generateComment();
	    		price = generatePrice();
	    		testProfiles[i] = new HMOProfile(studentNum,firstName,lastName,email,phone,price,talent,comment);
	    		wr.write(testProfiles[i].toCSV());    		
	    	}
		
		} catch (IOException e) {
			e.printStackTrace();
		}	     	     	     
	}
	
	// Generates a student number of length 7 -- the only unique value in the database
	private int generateStudentNumber(){
		String sStudentNum = "";
		int randomNum;
		
		// Ensures that every student number is unique
		do{
			sStudentNum = "";
			randomNum = randomWithRange(1,9);
			sStudentNum = sStudentNum + randomNum;
			for (int i = 1; i <7;i++){
				randomNum = randomWithRange(0,9);
				sStudentNum = sStudentNum + randomNum;
			}
		} while (studNumBST.contains(sStudentNum));
		studNumBST.put(sStudentNum,sStudentNum);
		
		return Integer.parseInt(sStudentNum);
	}
	
	// Generates a random First Name
	private String generateFirstName(){
		int randomNum;
		
		randomNum = randomWithRange(0,names.length-1);
		firstName = names[randomNum];
		return firstName;

	}
	
	// Generates a random Last Name
	private String generateLastName(){
		int randomNum;		
		randomNum = randomWithRange(0,names.length-1);
		lastName = names[randomNum];
		return lastName;
	}
	
	// Generates a random Email address
	private String generateEmail(){
		String sEmail = "";
		int randomNum;
		sEmail = firstName + lastName;
		randomNum = randomWithRange(0,emailSuffix.length-1);
		sEmail += randomWithRange(0,99);
		sEmail += emailSuffix[randomNum];
		return sEmail;
	}
	
	private long generatePhone(){
		String sPhone = "";
		int randomNum;
		
		// Ensures that every phone number is unique
		do{
			sPhone = "";
			randomNum = randomWithRange(1,9);
			sPhone = sPhone + randomNum;
			for (int i = 1; i <10;i++){
				randomNum = randomWithRange(0,9);
				sPhone = sPhone + randomNum;
			}
		} while (phoneBST.contains(sPhone));
		phoneBST.put(sPhone,sPhone);
		
		return Long.parseLong(sPhone);
	}
	
	// Generates talents
	private String generateTalent(){
		int randomNum = randomWithRange(0,talents.length-1);
		return talents[randomNum];
	}
	// 0 - Sports, 1- Education, 2-Food, 3-Arts, 4-Handy Man, 5- IT Guy, 6- Fashion/Style
	// Generates comments with respective talents
	private String generateComment(){
		int randomNum;
		
		if (talent.equals("Sports")){
			randomNum = randomWithRange(0,sportComments.length-1);
			return sportComments[randomNum];
		} else if (talent.equals("Education")){
			randomNum = randomWithRange(0,educationComments.length-1);
			return educationComments[randomNum];
		} else if (talent.equals("Foods")){
			randomNum = randomWithRange(0,foodComments.length-1);
			return foodComments[randomNum];
		} else if (talent.equals("Arts")){
			randomNum = randomWithRange(0,artComments.length-1);
			return artComments[randomNum];
		} else if (talent.equals("Handy Man")){
			randomNum = randomWithRange(0,handyManComments.length-1);
			return handyManComments[randomNum];
		} else if (talent.equals("IT Guy")){
			randomNum = randomWithRange(0,itComments.length-1);
			return itComments[randomNum];
		} else if (talent.equals("Fashion/Style")){
			randomNum = randomWithRange(0,fashionComments.length-1);
			return fashionComments[randomNum];
		} 
		return "nyeh";
	}
	
	private double generatePrice(){
		return (double) randomWithRange(1,100);
	}
	
	// Random number generator
	int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
}
