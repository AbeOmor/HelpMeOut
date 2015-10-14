package se2xb3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;
import java.util.Arrays;


public class HMORecords extends Observable{
    
	ArrayList<HMOProfile> HMORecords = new ArrayList<HMOProfile>();
	TST<HMOProfile> searchTST  = new TST<HMOProfile>();
	HMOProfile[] profilesArray;
	RedBlackBST<Integer, HMOProfile> allProfiles;
	private final File f = new File("src/se2xb3/testdatabase.csv");
	BoyerMoore bm;
	Object[][] data;

	public RedBlackBST<Integer,HMOProfile> getAllProfiles() {
		return allProfiles;
	}

	public void setAllProfiles(RedBlackBST<Integer,HMOProfile> allProfiles) {
		this.allProfiles = allProfiles;
	}

	public HMORecords() throws IOException
    {
		retrieveDatabase();
		profilesArray = new HMOProfile[HMORecords.size()];
		for (int i = 0; i < HMORecords.size(); i++){
			profilesArray[i] = HMORecords.get(i);
		}	
		data = new Object[profilesArray.length][7];
		//put intial data in the array to display in GUI
				for (int i = 0; i < profilesArray.length;i++){
					data[i] = profilesArray[i].forJTable().split(",");
				}
		this.HMORecords = getHMORecords();
		
    }

    // Retrieves the database
	protected void retrieveDatabase () throws IOException{

		Scanner sc = new Scanner(f); 

		allProfiles = new RedBlackBST<Integer, HMOProfile>();
		//The are going to be 7 main talent categories
		// 1 - Sports, 2- Education, 3-Food, 4-Arts, 5-Handy Man, 6- IT Guy, Fashion/Style
		while	(sc.hasNextLine()){
			String line = sc.nextLine();
			String[] entries = line.split(",");
			//System.out.println(Arrays.toString(entries));
			HMOProfile profile = new HMOProfile(Integer.parseInt(entries[0]), entries[1],  entries[2],  entries[3], Long.parseLong(entries[4]),Double.parseDouble(entries[5]), entries[6],entries[7]);
			HMORecords.add(profile);
			 
			allProfiles.put(profile.getStudNum(),profile);
		}
		sc.close();
    }
	
	/**
	 * To add a Record to a database, the records is first added to a RBBST so they are no dupilacte student numbers 
	 * @param studNum
	 * @param firstN
	 * @param lastN
	 * @param email
	 * @param phone
	 * @param talent
	 * @param price
	 * @param comment
	 * @throws IOException
	 */
	public void addRecord(int studNum, String firstN,  String lastN,  String email, long phone,  double price,String talent, String comment) throws IOException{
		HMOProfile profile = new HMOProfile(studNum,firstN,lastN,email,phone,price,talent,comment);
		HMORecords.add(profile);
		
		allProfiles.put(profile.getStudNum(),profile);
		updateDatabase();
	}
	
	/**
	 * //The are going to be 7 main talent categories
		// 0 - Sports, 1- Education, 2-Food, 3-Arts, 4-Handy Man, 5- IT Guy, 6- Fashion/Style
	 * @param studNum
	 * @param talent
	 * @throws IOException
	 */
	public void deleteTalent(int studNum,int talent) throws IOException{
		allProfiles.delete(studNum);	
	}
	
	/**
	 * a method that finds profile you want to change and changes the entry
	 * @param studNum
	 * @param talent
	 * @param fieldChange
	 * @param theChange
	 * @throws IOException
	 */
	public void updateEntry(int studNum,int talent, String fieldChange, String theChange) throws IOException{
		HMOProfile profile = allProfiles.get(studNum);
		if (fieldChange.equals("First Name")){
			profile.setFirstN(theChange);
		} else if (fieldChange.equals("Last Name")){
			profile.setLastN(theChange);
		} else if (fieldChange.equals("Email")){
			profile.setEmail(theChange);
		} else if (fieldChange.equals("Phone #")) {
			profile.setPhone(Long.parseLong(theChange));
		} else if (fieldChange.equals("Price")) {
			profile.setPrice(Double.parseDouble(theChange));
		} else if (fieldChange.equals("Comment")){
			profile.setComment(theChange);
		} 
		//change all exception Talent
		//talentCat[talent].delete(studNum);	
		allProfiles.put(studNum,profile);	
	}
	
	/**
	 * Delete the student from entire database.
	 * @param studNum
	 * @throws IOException
	 */
	public void deleteRecord(int studNum) throws IOException{

		allProfiles.delete(studNum); 
	}
	
	/**
	 * Updates the database, takes the BST and overwrites the old CSV file
	 * @throws IOException
	 */
	
	public void updateDatabase() throws IOException{
		 Writer wr = null;
	     wr = new BufferedWriter(new FileWriter(f));
	     	     	     
	  
			for (Integer s : allProfiles.keys()) {
				wr.write(allProfiles.get(s).toCSV());
			}
		
	     wr.close();
	     
	}
	
	// Sorts based on comparator
	public void sortFirstName(){
		MergeX.sort(profilesArray,HMOProfile.FirstNameComparator);
	}
	
	public void sortLastName(){
		MergeX.sort(profilesArray,HMOProfile.LastNameComparator);
	}
	
	public void sortEmail(){
		MergeX.sort(profilesArray,HMOProfile.EmailComparator);
	}
	
	public void sortPhone(){
		MergeX.sort(profilesArray,HMOProfile.PhoneComparator);
	}

	public void sortTalent(){
		MergeX.sort(profilesArray,HMOProfile.TalentComparator);
	}

	public void sortPrice(){
		MergeX.sort(profilesArray,HMOProfile.PriceComparator);
	}
	
	// Flips the data to ascending or descending order from the already sorted array
	public void flipData(){
		int counter =0;
		HMOProfile[] revProfiles = new HMOProfile[profilesArray.length];
		for (int i = profilesArray.length -1; i >= 0; i--){
			revProfiles[counter] = profilesArray[i];
			counter++;				
		}
		profilesArray = revProfiles.clone();
	}
	
	// Searches for profiles based on the search bar input
	// Utilizes the BoyerMoore algorithm and BST's
	public void search(String searchString){
		
		bm = new BoyerMoore(searchString.toUpperCase());
		ArrayList<Integer> profileList = new ArrayList<Integer>();
		for (int i = 0; i < profilesArray.length; i++){
			if (bm.search(profilesArray[i].toString().toUpperCase()) != profilesArray[i].toString().length()){
				profileList.add(profilesArray[i].getStudNum());
			}
		}
		
		//System.out.println(profileList.size());

		profilesArray = new HMOProfile[profileList.size()];
		
		for (int i = 0; i < profileList.size();i++){
			profilesArray[i] = allProfiles.get(profileList.get(i));
		}		
	}
	
    public ArrayList<HMOProfile> getHMORecords() {
		return HMORecords;
	}

    public Object[][] getData() {
		return data;
	}

	public void setData(HMOProfile[] profileArray,Object[][] object) {
		//put intial data in the array to display in GUI
		object = new Object[profilesArray.length][7];
		for (int i = 0; i < profilesArray.length;i++){
			object[i] = profilesArray[i].forJTable().split(",");
		}
		this.data = object;
	}

	public void setProfileArray(HMOProfile[] profile) {
	//for (int i = 0; i < profilesArray.length;i++){
		this.profilesArray = profile;
	//}
	}
	
	
    }
