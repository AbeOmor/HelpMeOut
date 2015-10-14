package se2xb3;

import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HMOController implements ActionListener{
	private HMOUserInterface view;
	private HMORecords HMOModel;
	// the counter is to help with flip the sort every time you press a button
	int counter = 0;
	
	
	/**
	 * Initializes the HMO controller and it's associated
	 * view and models. The controller will listen for updates
	 * from the view and model after it is created.
	 * @throws IOException 
	 */
	public HMOController() throws IOException {
		HMOModel = new HMORecords ();
		//HMOModel.addObserver(this);
		view = new HMOUserInterface(this);
	}

	/**
	 * This method is called when an event on the view happens.
	 * This will be some sort of a user input event and this
	 * method reacts to the user input events by updating the
	 * appropriate models.
	 * This method call different methods from the view, to change the view accordingly
	 * @param e the event
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Look up the component identifier of this event
		AppState type = view.lookupComponentType(e.getSource());
		HMOProfile[] sortArray = new HMOProfile[HMOModel.profilesArray.length];
		
		//search from the search field when the user presses enter
		
		 if (e.getSource() == view.textField1) {
			 view.setSearchView(view.textField1.getText());
	        }
		 if (e.getSource() == view.textField2) {
			 view.setSearchView(view.textField2.getText());
	        }
		// Decide what to do based off of what component it is
		switch (type) {
		
		case SEARCH:
			view.setSearchView(view.textField1.getText());
			break;
			
		case SEARCH2:
			view.setSearchView(view.textField2.getText());
			break;
			
		case HELP_STATE:
			view.setCurrentMenu("category");
			break;
		case SERVICE_STATE:
			view.setCurrentMenu("service");
			break;
		case SPORT_STATE:
			view.setCatView("sports");
			break;
		case FOOD_STATE:
			view.setCatView("foods");
			break;
		case ARTS_STATE:
			view.setCatView("arts");
			break;
		case IT_STATE:
			view.setCatView("it");
			break;
		case EDUCATION_STATE:
			view.setCatView("edu");
			break;
		case HANDY_STATE:
			view.setCatView("handy");
			break;
		case ALL_STATE:
			view.setCatView("all");
			break;
		case FASHION_STATE:
			view.setCatView("fashion");
			break;
		case SUBMIT_STATE:
			//popup window, after the user enter new data the program will be closed
			JOptionPane.showMessageDialog(null, "The entry has been saved, the program will be closed");
			try {
				
//				if (HMOModel.allProfiles.get(Integer.parseInt(view.studField.getText())) != null){
//					
//				}
				
				//get the values from the fields and then create a new profile accordingly
			String value=view.comboBox1.getSelectedItem().toString();
			HMOProfile newProfile = new HMOProfile(Integer.parseInt(view.studField.getText()),view.firstField.getText(),view.lastField.getText(),
					view.emailField.getText(),Long.parseLong(view.phoneField.getText()),Double.parseDouble(view.priceField.getText()),
					value,view.textArea1.getText());
			
			HMOModel.addRecord(Integer.parseInt(view.studField.getText()),view.firstField.getText(),view.lastField.getText(),
					view.emailField.getText(),Long.parseLong(view.phoneField.getText()),Double.parseDouble(view.priceField.getText()),
					value,view.textArea1.getText());
	
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   System.exit(0);
		   
			break;
		
		case BACK_STATE:
			//when you press back it will restore the whole database, so will be about the search everything in the database again
			view.setCatView("all");
			view.setCurrentMenu("back");
			break;
		case FIRSTN:
			
			view.setDataView("firstN",counter);
			counter++;
			break;
		case LASTN:
			view.setDataView("lastN",counter);
			counter++;
           break;
		case PHONE:
		view.setDataView("phone",counter);
			counter++;
			break;
		case TALENT:
		view.setDataView("talent",counter);
			counter++;
            break;
		case EMAIL:
		view.setDataView("email",counter);
			counter++;
		break;
		case PRICE:
		view.setDataView("price",counter);
			counter++;
           break;
		default:
			// This should never happen
			break;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		//Initialize the GUI 
		HMOController hc = new HMOController();
		hc.view.setVisible(true);
		    
		 }
}
