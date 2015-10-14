package se2xb3;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class HMORecordsTest {

	@Test
	public void test() throws IOException {
		HMORecords test = new HMORecords();
		test.retrieveDatabase();
		HMOProfile testProfile1 = new HMOProfile(1327828,"blee","a","jaynguyen@gmail.com",289684998,30.0,"Fashion/Style","ab");
		HMOProfile testProfile2 = new HMOProfile(1327829,"bleeg","E","jaynguyen@gmail.com",289684999,40.0,"Fashion/Style","da");
		test.addRecord(1327828,"blee","a","jaynguyen@gmail.com",289684998,30.0,"Fashion/Style","ab");
		test.addRecord(1327829,"bleeg","E","jaynguyen@gmail.com",289684999,40.0,"Fashion/Style","da");
		
		// addRecord test
		assertEquals(true,test.allProfiles.contains(1327828));
		//search test
		test.search("blee");
		assertTrue(test.profilesArray.length == 2);
		
		// Sort first name test
		test.sortFirstName();
		assertTrue(test.profilesArray[0].equals(testProfile1));
		
		// Flip data test
		test.flipData();
		assertTrue(test.profilesArray[0].equals(testProfile2));
		
		// Sort Last name test
		test.sortLastName();
		assertTrue(test.profilesArray[0].equals(testProfile1));
		
		// Sort email test
		test.sortEmail();
		assertTrue(test.profilesArray[0].equals(testProfile1));
		
		// Sort phone test
		test.sortPhone();
		assertTrue(test.profilesArray[0].equals(testProfile1));
		
		// Sort price test
		test.sortPrice();
		assertTrue(test.profilesArray[0].equals(testProfile1));
		
		// Sort talent test
		test.sortTalent();
		assertTrue(test.profilesArray[0].equals(testProfile1));
		
		// Delete record test
		test.deleteRecord(1327829);
		assertTrue(test.allProfiles.contains(1328929) == false);
		
		// Update entry test
		test.updateEntry(1327828, 1, "Price", "10.0");
		assertTrue(!test.profilesArray[0].equals(testProfile1));		
		
	}

}
