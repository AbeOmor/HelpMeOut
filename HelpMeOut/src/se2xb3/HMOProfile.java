package se2xb3;

import java.util.Arrays;
import java.util.Comparator;

// A profile consists of a student number, first name, last name, email, phone number, talent, price and a talent along with an optional comment
public class HMOProfile implements Comparable<HMOProfile> {
		
	private int studNum;
	private String firstN;
	private String lastN; 
	private String email; 
	private long phone; 
	private String talent;
	private double  price;
	private String comment;
	


	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

		HMOProfile() {
		}
		
		HMOProfile( int studNum, String firstN,  String lastN,  String email, long phone,  double price, String talent, String comment)
		{
			this.studNum = studNum;
			this.firstN = firstN;
			this.lastN = lastN;
			this.email = email;
			this.phone = phone;
			this.talent = talent;
			this.price = price;
			this.comment = comment;
		}
		
		HMOProfile(HMOProfile object) {
			this.studNum = object.studNum;
			this.firstN = object.firstN;
			this.lastN = object.lastN;
			this.email = object.email;
			this.phone = object.phone;
			this.talent = object.talent;
			this.price = object.price;
			this.comment = object.comment;
		}
		
		public int getStudNum() {
			return studNum;
		}
		public void setStudNum(int studNum) {
			this.studNum = studNum;
		}
		public String getFirstN() {
			return firstN;
		}
		public void setFirstN(String firstN) {
			this.firstN = firstN;
		}
		public String getLastN() {
			return lastN;
		}
		public void setLastN(String lastN) {
			this.lastN = lastN;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public long getPhone() {
			return phone;
		}
		public void setLocation(int location) {
			this.phone = phone;
		}
		public String getTalent() {
			return talent;
		}
		public void setTalent(String talent) {
			this.talent = talent;
		}
		
		public void setPrice(double price) {
			this.price = price;
		}
		
		public double getPrice() {
			return this.price;
		}
		
		// Converts to string
		public String toString(){
			return getFirstN() + " " + getLastN() + " " + getEmail() + " " + getPhone() + " $"+ getPrice() + " " + getTalent() + " " + getComment();
			
		}
		
		// Converts the profile in a .csv format
		public String toCSV(){
			return getStudNum() + "," + getFirstN() + "," + getLastN() + "," + getEmail() + "," + getPhone() + ","+ getPrice() + "," + getTalent() + "," + getComment() + "\n";
			
		} 
		
		//convert the array so it is readable by the JTable in the GUI remove the studentid
		public String forJTable(){
			return getFirstN() + "," + getLastN() + "," + getEmail() + "," + getPhone() + ","+ getPrice() + "," + getTalent() + "," + getComment() + "\n";
			
		} 
		
		public boolean equals(HMOProfile object){
			
			if (this.studNum == object.studNum && 
				this.firstN.equals(object.firstN) && 
				this.lastN.equals(object.lastN) &&
				this.email.equals(object.email) &&
				this.phone == object.phone &&
				this.talent.equals(object.talent) &&
				this.price == object.price){
				return true;
				}
			
			return false;
		}
		

		@Override
		public int compareTo(HMOProfile object) {
			if (this.studNum > object.studNum){
				return 1;
				}
				else if (this.studNum == object.studNum)
				return 0;
				else{
				return -1;
			}	
		}
		
		// First Name Comparator
		public static Comparator<HMOProfile> FirstNameComparator 
				= new Comparator<HMOProfile>() {
			
			@Override
			public int compare(HMOProfile profile1, HMOProfile profile2){
				 String firstName1 = profile1.getFirstN().toUpperCase();
			     String firstName2 = profile2.getFirstN().toUpperCase();
		 
			     //ascending order
			     return firstName1.compareTo(firstName2);
			}
		
		};
		
		// Last Name comparator
		public static Comparator<HMOProfile> LastNameComparator 
				= new Comparator<HMOProfile>() {
				
				@Override
				public int compare(HMOProfile profile1, HMOProfile profile2){
				String lastName1 = profile1.getLastN().toUpperCase();
				String lastName2 = profile2.getLastN().toUpperCase();
		 
			    //ascending order
				return lastName1.compareTo(lastName2);
			}

		};
		
		// Email comparator
		public static Comparator<HMOProfile> EmailComparator 
				= new Comparator<HMOProfile>() {
				@Override
				public int compare(HMOProfile profile1, HMOProfile profile2){
				String email1 = profile1.getEmail().toUpperCase();
				String email2 = profile2.getEmail().toUpperCase();
		 
			    //ascending order
				return email1.compareTo(email2);
			}
		};
		
		
		// Phone comparator
		public static Comparator<HMOProfile> PhoneComparator 
				= new Comparator<HMOProfile>() {
				@Override
				public int compare(HMOProfile profile1, HMOProfile profile2){
				long phone1 = profile1.getPhone();
				long phone2 = profile2.getPhone();
		 
			    //ascending order
				if (phone1 > phone2){
					return 1;
				} else if (phone1 == phone2){
					return 0;
				} else {
					return -1;
				}
			}
		};
		
		
		// Talent comparator
		public static Comparator<HMOProfile> TalentComparator 
				= new Comparator<HMOProfile>() {
				@Override
				public int compare(HMOProfile profile1, HMOProfile profile2){
				String talent1 = profile1.getTalent().toUpperCase();
				String talent2 = profile2.getTalent().toUpperCase();
		 
			    //ascending order
				return talent1.compareTo(talent2);
			}
		};
		
		
		// Price Comparator
		public static Comparator<HMOProfile> PriceComparator 
				= new Comparator<HMOProfile>() {
				@Override
				public int compare(HMOProfile profile1, HMOProfile profile2){
				Double price1 = profile1.getPrice();
				Double price2 = profile2.getPrice();
		 
			    //ascending order
				if (price1 > price2){
					return 1;
				} else if (price1 == price2){
					return 0;
				} else {
					return -1;
				}
			}
		};
		
}
