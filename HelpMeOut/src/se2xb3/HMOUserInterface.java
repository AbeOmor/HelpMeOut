

package se2xb3;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import org.w3c.dom.events.EventException;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author ABraham Omorogbe
 */

public class HMOUserInterface extends JFrame {
	public HMOUserInterface(HMOController controller) throws IOException {

		this.controller = controller;
		initComponents();


	}

	//UGLY ASS GUI Code
	//Basically, all the buttons have ActionListeners, and the 2 search Fields and JComboText
	//All the buttons are also put into a hashMap which is associated with the
	//AppState Enum
	//The rest of the stuff is just formating and making the GUI looks good.
	
	public void initComponents() throws IOException {		
		componentMap = new HashMap<Object, AppState>();

		introPanel = new JPanel();
		menuBar4 = new JMenuBar();
		menu9 = new JMenu();
		menuItem12 = new JMenuItem();
		menuItem13 = new JMenuItem();
		panel8 = new JPanel();

		serviceButton = new JButton();
		helpButton = new JButton();
		JButton backButton = new JButton();

		componentMap.put(serviceButton, AppState.SERVICE_STATE);
		componentMap.put(helpButton, AppState.HELP_STATE);
		componentMap.put(backButton, AppState.BACK_STATE);
		serviceButton.addActionListener(controller);
		helpButton.addActionListener(controller);
		backButton.addActionListener(controller);

		panel1 = new JPanel();
		label3 = new JLabel();
		categoryPanel = new JPanel();
		menuBar2 = new JMenuBar();
		menu2 = new JMenu();
		menuItem3 = new JMenuItem();
		menuItem4 = new JMenuItem();
		menu3 = new JMenu();
		textField1 = new JTextField(20);
		menu4 = new JMenu();
		menuItem5 = new JMenuItem();
		menuItem6 = new JMenuItem();

		panel10 = new JPanel();
		panel11 = new JPanel();
		sportsButton = new JButton();
		panel17 = new JPanel();
		educationButton = new JButton();
		panel14 = new JPanel();
		foodButton = new JButton();
		panel13 = new JPanel();
		artsButton = new JButton();
		panel12 = new JPanel();
		handyButton = new JButton();
		panel16 = new JPanel();
		itButton = new JButton();
		panel15 = new JPanel();
		fashionButton = new JButton();
		panel18 = new JPanel();
		allButton = new JButton();
		sortPanel = new JPanel();
		sortPanel.setLayout(new FlowLayout());

		componentMap.put(sportsButton, AppState.SPORT_STATE);
		componentMap.put(educationButton, AppState.EDUCATION_STATE);
		componentMap.put(foodButton, AppState.FOOD_STATE);
		componentMap.put(artsButton, AppState.ARTS_STATE);
		componentMap.put(handyButton, AppState.HANDY_STATE);
		componentMap.put(itButton, AppState.IT_STATE);
		componentMap.put(fashionButton, AppState.FASHION_STATE);
		componentMap.put(allButton, AppState.ALL_STATE);

		sportsButton.addActionListener(controller);
		educationButton.addActionListener(controller);
		foodButton.addActionListener(controller);
		artsButton.addActionListener(controller);
		handyButton.addActionListener(controller);
		itButton.addActionListener(controller);
		fashionButton.addActionListener(controller);
		allButton.addActionListener(controller);

		dataPanel = new JPanel();
		menuBar3 = new JMenuBar();
		menu5 = new JMenu();
		menuItem7 = new JMenuItem();
		menuItem8 = new JMenuItem();
		menu6 = new JMenu();
		textField2 = new JTextField(20);
		menu7 = new JMenu();
		menuItem9 = new JMenuItem();
		menuItem10 = new JMenuItem();
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		servicePanel = new JPanel();
		label7 = new JLabel();
		studField= new JTextField();
		label4 = new JLabel();
		firstField = new JTextField();
		label5 = new JLabel();
		lastField = new JTextField();
		label8 = new JLabel();
		emailField = new JTextField();
		label6 = new JLabel();
		phoneField = new JTextField();
		label9 = new JLabel();
		priceField = new JTextField();
		label10 = new JLabel();
		//comboBox1 = new JComboBox();
		label11 = new JLabel();
		scrollPane2 = new JScrollPane();
		textArea1 = new JTextArea();

		submitButton = new JButton();
		componentMap.put(submitButton, AppState.SUBMIT_STATE);
		editButton = new JButton();
		componentMap.put(editButton, AppState.EDIT_STATE);
		submitButton.addActionListener(controller);
		editButton.addActionListener(controller);

		firstNButton = new JButton();
		lastNButton = new JButton();
		emailButton = new JButton();
		phoneButton = new JButton();
		talentButton = new JButton();
		priceButton = new JButton();
		commentButton = new JButton();
		database = new JTable();

		firstNButton.addActionListener(controller);
		lastNButton.addActionListener(controller);
		emailButton.addActionListener(controller);
		phoneButton.addActionListener(controller);
		talentButton.addActionListener(controller);
		priceButton.addActionListener(controller);
		commentButton.addActionListener(controller);

		componentMap.put(firstNButton, AppState.FIRSTN);
		componentMap.put(lastNButton, AppState.LASTN);
		componentMap.put(emailButton, AppState.EMAIL);
		componentMap.put(phoneButton, AppState.PHONE);
		componentMap.put(talentButton, AppState.TALENT);
		componentMap.put(priceButton, AppState.PRICE);
		componentMap.put(commentButton, AppState.COMMENT);




		//Basically I add a listener for all the headers
		//the database is sorted based on the header clicked
		database = new JTable(model.getData(), columnNames);
		tableModel = new DefaultTableModel(model.getData(),columnNames);
		database = new JTable(model.getData(), columnNames);
		//database.setModel(tableModel);

		/*  database.getTableHeader().addMouseListener(new MouseAdapter(){
		    @Override
		    public void mouseClicked(MouseEvent j) {
		        int col = database.columnAtPoint(j.getPoint());
		        String name = database.getColumnName(col);
		        HMOProfile[] sortArray = new HMOProfile[model.profilesArray.length];
		        System.out.println("Column index selected " + col + " " + name);
		        switch (col){
		        case 0:
		        	sortArray = new HMOProfile[model.profilesArray.length];
		        	model.sortFirstName();
		        	sortArray = model.profilesArray;
		        	model.setData(sortArray,model.getData());
		        	database = new JTable(model.getData(), columnNames);
		            database.repaint();
		 			break;

		        case 1:
		        	sortArray = new HMOProfile[model.profilesArray.length];
		        	model.sortLastName();
		        	sortArray = model.profilesArray;
		        	model.setData(sortArray,model.getData());
		        	database = new JTable(model.getData(), columnNames);
		            database.repaint();
		 			break;

		        case 2:
		        	sortArray = new HMOProfile[model.profilesArray.length];
		        	model.sortEmail();;
		        	sortArray = model.profilesArray;
		        	model.setData(sortArray,model.getData());
		        	database = new JTable(model.getData(), columnNames);
		            database.repaint();
		 			break;

		        case 3:
		        	sortArray = new HMOProfile[model.profilesArray.length];
		        	model.sortPhone();
		        	sortArray = model.profilesArray;
		        	model.setData(sortArray,model.getData());
		        	database = new JTable(model.getData(), columnNames);
		            database.repaint();
		 			break;

		        case 4:
		        	sortArray = new HMOProfile[model.profilesArray.length];
		        	model.sortPrice();
		        	sortArray = model.profilesArray;
		        	model.setData(sortArray,model.getData());
		        	database = new JTable(model.getData(), columnNames);
		            database.repaint();
		 			break;

		        case 5:
		        	sortArray = new HMOProfile[model.profilesArray.length];
		        	model.sortTalent();
		        	sortArray = model.profilesArray;
		        	model.setData(sortArray,model.getData());
		        	database = new JTable(model.getData(), columnNames);
		            database.repaint();
		 			break;
		        case 6:
		        	sortArray = new HMOProfile[model.profilesArray.length];
		        	model.sortLastName();
		        	sortArray = model.profilesArray;
		        	model.setData(sortArray,model.getData());
		        	database = new JTable(model.getData(), columnNames);
		            database.repaint();
		 			break;


		        default:
		 			// This should never happen
		 			break;
		        }

		    }
		});*/


		//======== this ========
		contentPane = getContentPane();
		contentPane.setLayout(new CardLayout());

		cardsPane = new CardLayout();

		//======== panel6 ========
		{


			introPanel.setLayout(new GridBagLayout());
			((GridBagLayout)introPanel.getLayout()).columnWidths = new int[] {0, 0};
			((GridBagLayout)introPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
			((GridBagLayout)introPanel.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
			((GridBagLayout)introPanel.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

			introPanel.add(menuBar4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));

			//======== panel8 ========
			{
				panel8.setLayout(new FlowLayout());

				//---- button1 ----
				serviceButton.setText("Service Provider");
				panel8.add(serviceButton);

				//---- button2 ----
				helpButton.setText("Help Seeker");
				panel8.add(helpButton);
			}
			introPanel.add(panel8, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));

			//======== panel1 ========
			{
				panel1.setLayout(new FlowLayout());

				//---- label3 ----
				ImageIcon pic = new ImageIcon("src/se2xb3/HelpMeOut.png");
				panel1.add(new JLabel(pic));
			}
			introPanel.add(panel1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(introPanel, "card1");

		//======== panel9 ========
		{
			categoryPanel.setLayout(new BorderLayout());

			JPanel topbar2 = new JPanel();
			topbar2.setLayout(new FlowLayout());
			topbar2.add(textField1);
			JButton searchButton = new JButton();
			searchButton.setText("Search");
			componentMap.put(searchButton, AppState.SEARCH);
			searchButton.addActionListener(controller);
			topbar2.add(searchButton);
			
				textField1.addActionListener(controller);
				textField2.addActionListener(controller);
			
			categoryPanel.add(topbar2, BorderLayout.NORTH);

			//======== panel10 ========
			{
				panel10.setLayout(new GridBagLayout());
				((GridBagLayout)panel10.getLayout()).columnWidths = new int[] {100, 100, 100, 100, 0};
				((GridBagLayout)panel10.getLayout()).rowHeights = new int[] {100, 100, 0};
				((GridBagLayout)panel10.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0, 1.0, 1.0E-4};
				((GridBagLayout)panel10.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

				//======== panel11 ========
				{
					panel11.setLayout(new GridBagLayout());
					((GridBagLayout)panel11.getLayout()).columnWidths = new int[] {111, 0};
					((GridBagLayout)panel11.getLayout()).rowHeights = new int[] {0, 0, 0};
					((GridBagLayout)panel11.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
					((GridBagLayout)panel11.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

					//---- button11 ----
					sportsButton.setText("Sports");
					ImageIcon pic = new ImageIcon("src/se2xb3/sports.jpeg");
					panel11.add(new JLabel(pic));
					panel11.add(sportsButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
				}
				panel10.add(panel11, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));

				//======== panel17 ========
				{
					panel17.setLayout(new GridBagLayout());
					((GridBagLayout)panel17.getLayout()).columnWidths = new int[] {0, 0};
					((GridBagLayout)panel17.getLayout()).rowHeights = new int[] {0, 0, 0};
					((GridBagLayout)panel17.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
					((GridBagLayout)panel17.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

					//---- button12 ----
					educationButton.setText("Education");
					ImageIcon pic = new ImageIcon("src/se2xb3/education.jpeg");
					panel17.add(new JLabel(pic));
					panel17.add(educationButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
				}
				panel10.add(panel17, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));

				//======== panel14 ========
				{
					panel14.setLayout(new GridBagLayout());
					((GridBagLayout)panel14.getLayout()).columnWidths = new int[] {0, 0};
					((GridBagLayout)panel14.getLayout()).rowHeights = new int[] {0, 0, 0};
					((GridBagLayout)panel14.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
					((GridBagLayout)panel14.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

					//---- button13 ----
					foodButton.setText("Foods");
					ImageIcon pic = new ImageIcon("src/se2xb3/food.jpeg");
					panel14.add(new JLabel(pic));
					panel14.add(foodButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
				}
				panel10.add(panel14, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));

				//======== panel13 ========
				{
					panel13.setLayout(new GridBagLayout());
					((GridBagLayout)panel13.getLayout()).columnWidths = new int[] {0, 0};
					((GridBagLayout)panel13.getLayout()).rowHeights = new int[] {0, 0, 0};
					((GridBagLayout)panel13.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
					((GridBagLayout)panel13.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

					//---- button14 ----
					artsButton.setText("Arts");
					ImageIcon pic = new ImageIcon("src/se2xb3/art.jpeg");
					panel13.add(new JLabel(pic));
					panel13.add(artsButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
				}
				panel10.add(panel13, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));

				//======== panel12 ========
				{
					panel12.setLayout(new GridBagLayout());
					((GridBagLayout)panel12.getLayout()).columnWidths = new int[] {0, 0};
					((GridBagLayout)panel12.getLayout()).rowHeights = new int[] {0, 0, 0};
					((GridBagLayout)panel12.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
					((GridBagLayout)panel12.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

					//---- button15 ----
					handyButton.setText("Handy-Man");
					ImageIcon pic = new ImageIcon("src/se2xb3/handy-Man.jpeg");
					panel12.add(new JLabel(pic));
					panel12.add(handyButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
				}
				panel10.add(panel12, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));

				//======== panel16 ========
				{
					panel16.setLayout(new GridBagLayout());
					((GridBagLayout)panel16.getLayout()).columnWidths = new int[] {0, 0};
					((GridBagLayout)panel16.getLayout()).rowHeights = new int[] {0, 0, 0};
					((GridBagLayout)panel16.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
					((GridBagLayout)panel16.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

					//---- button16 ----
					itButton.setText("IT Guy");
					ImageIcon pic = new ImageIcon("src/se2xb3/it-man.jpeg");
					panel16.add(new JLabel(pic));
					panel16.add(itButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
				}
				panel10.add(panel16, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));

				//======== panel15 ========
				{
					panel15.setLayout(new GridBagLayout());
					((GridBagLayout)panel15.getLayout()).columnWidths = new int[] {0, 0};
					((GridBagLayout)panel15.getLayout()).rowHeights = new int[] {0, 0, 0};
					((GridBagLayout)panel15.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
					((GridBagLayout)panel15.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

					//---- button17 ----
					fashionButton.setText("Fashion");
					ImageIcon pic = new ImageIcon("src/se2xb3/fashion.jpg");
					panel15.add(new JLabel(pic));
					panel15.add(fashionButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
				}
				panel10.add(panel15, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));

				//======== panel18 ========
				{
					panel18.setLayout(new GridBagLayout());
					((GridBagLayout)panel18.getLayout()).columnWidths = new int[] {0, 0};
					((GridBagLayout)panel18.getLayout()).rowHeights = new int[] {0, 0, 0};
					((GridBagLayout)panel18.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
					((GridBagLayout)panel18.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

					//---- button18 ----
					allButton.setText("All");
					ImageIcon pic = new ImageIcon("src/se2xb3/all.jpg");
					panel18.add(new JLabel(pic));
					panel18.add(allButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
							GridBagConstraints.CENTER, GridBagConstraints.BOTH,
							new Insets(0, 0, 0, 0), 0, 0));
				}
				panel10.add(panel18, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
			}
			categoryPanel.add(panel10, BorderLayout.CENTER);
		}
		contentPane.add(categoryPanel, "card2");

		//======== panel19 ========
		{
			dataPanel.setLayout(new BorderLayout());


			JPanel topbar = new JPanel();
			JPanel searchPanel = new JPanel();
			topbar.setLayout(new GridLayout(2,0));
			searchPanel.setLayout(new FlowLayout());
			searchPanel.add(textField2);
			JButton searchButton2 = new JButton();
			searchButton2.setText("Search");
			componentMap.put(searchButton2, AppState.SEARCH2);
			searchButton2.addActionListener(controller);
			searchPanel.add(searchButton2);
			topbar.add(searchPanel);



			firstNButton.setText("First Name");
			lastNButton.setText("Last Name");
			emailButton.setText("Email");
			phoneButton.setText("Phone");
			talentButton.setText("Talent");
			priceButton.setText("Price");
			commentButton.setText("Specialty");
			backButton.setText("<< Go Back");

			sortPanel.add(firstNButton);
			sortPanel.add(lastNButton);
			sortPanel.add(emailButton);
			sortPanel.add(phoneButton); 
			sortPanel.add(priceButton);
			sortPanel.add(talentButton);
			//sortPanel.add(commentButton);
			sortPanel.add(backButton);

			topbar.add(sortPanel);
			dataPanel.add(topbar, BorderLayout.NORTH);
			//resizeColumnWidth(database);
			scrollPane1.add(database.getTableHeader());
			
			//======== scrollPane1 ========
			{
				scrollPane1.setViewportView(database);
			}
			dataPanel.add(scrollPane1, BorderLayout.CENTER);
		}
		contentPane.add(dataPanel, "card3");

		//======== panel20 ========
		{
			servicePanel.setBorder(Borders.DLU4);
			servicePanel.setLayout(new FormLayout(
					"[50dlu,default], $lcgap, [100dlu,default]",
					"8*(default, $lgap), default"));

			//---- label7 ----
			label7.setText("Student Number:");
			servicePanel.add(label7, CC.xy(1, 1));
			servicePanel.add(studField, CC.xy(3, 1));
			studField.addActionListener(controller);
			//---- label4 ----
			label4.setText("First Name:");
			servicePanel.add(label4, CC.xy(1, 3));
			servicePanel.add(firstField, CC.xy(3, 3));
			firstField.addActionListener(controller);
			//---- label5 ----
			label5.setText("Last Name:");
			servicePanel.add(label5, CC.xy(1, 5));
			servicePanel.add(lastField, CC.xy(3, 5));
			lastField.addActionListener(controller);
			//---- label8 ----
			label8.setText("Email:");
			servicePanel.add(label8, CC.xy(1, 7));
			servicePanel.add(emailField, CC.xy(3, 7));
			emailField.addActionListener(controller);
			//---- label6 ----
			label6.setText("Phone Number:");
			servicePanel.add(label6, CC.xy(1, 9));
			servicePanel.add(phoneField, CC.xy(3, 9));
			phoneField.addActionListener(controller);
			//---- label9 ----
			label9.setText("Price($):");
			servicePanel.add(label9, CC.xy(1, 11));
			servicePanel.add(priceField, CC.xy(3, 11));
			priceField.addActionListener(controller);
			//---- label10 ----
			label10.setText("Talent:");
			servicePanel.add(label10, CC.xy(1, 13));


			comboBox1.addActionListener(controller);
			servicePanel.add(comboBox1, CC.xy(3, 13));

			//---- label11 ----
			label11.setText("Specfics (seperate with commas (,)):");
			servicePanel.add(label11, CC.xy(1, 15));

			//======== scrollPane2 ========
			{
				scrollPane2.setViewportView(textArea1);
			}
			servicePanel.add(scrollPane2, CC.xy(3, 15));

			submitButton.setText("Submit Profile >>");
			servicePanel.add(submitButton, CC.xy(3, 17));
		}
		contentPane.add(servicePanel, "card4");

		//when you hit close, shut the program down
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(getOwner());
	}


	private JPanel introPanel;
	private JMenuBar menuBar4;
	private JMenu menu9;
	private JMenuItem menuItem12;
	private JMenuItem menuItem13;
	private JPanel panel8;
	private JButton serviceButton;
	private JButton helpButton;
	private JPanel panel1;
	private JLabel label3;
	private JPanel categoryPanel;
	private JMenuBar menuBar2;
	private JMenu menu2;
	private JMenuItem menuItem3;
	private JMenuItem menuItem4;
	private JMenu menu3;
	JTextField textField1;
	private JMenu menu4;
	private JMenuItem menuItem5;
	private JMenuItem menuItem6;
	private JPanel panel10;
	private JPanel panel11;
	private JButton sportsButton;
	private JPanel panel17;
	private JButton educationButton;
	private JPanel panel14;
	private JButton foodButton;
	private JPanel panel13;
	private JButton artsButton;
	private JPanel panel12;
	private JButton handyButton;
	private JPanel panel16;
	private JButton itButton;
	private JPanel panel15;
	private JButton fashionButton;
	private JPanel panel18;
	private JButton allButton;
	JPanel dataPanel;
	private JMenuBar menuBar3;
	private JMenu menu5;
	private JMenuItem menuItem7;
	private JMenuItem menuItem8;
	private JMenu menu6;
	JTextField textField2;
	private JMenu menu7;
	private JMenuItem menuItem9;
	private JMenuItem menuItem10;
	private JScrollPane scrollPane1;
	private JTable table1;
	private JPanel servicePanel;
	private JLabel label7;
	JTextField studField;
	private JLabel label4;
	JTextField firstField;
	private JLabel label5;
	JTextField lastField;
	private JLabel label8;
	JTextField emailField;
	private JLabel label6;
	JTextField phoneField;
	private JLabel label9;
	JTextField priceField;
	private JLabel label10;
	//JComboBox comboBox1;
	private JLabel label11;
	private JScrollPane scrollPane2;
	JTextArea textArea1;
	private JButton submitButton;
	private CardLayout cardsPane;
	Container contentPane;
	private HMOController controller;
	private JButton firstNButton;
	private JButton lastNButton ;
	private JButton emailButton ;
	private JButton phoneButton ;
	private JButton talentButton ;
	private JButton priceButton ;
	private JButton commentButton;
	private JButton editButton;
	private HashMap<Object, AppState> componentMap;
	public Object[][] data;
	private HMORecords model = new HMORecords();
	public JTable database;
	String[] categories = new String[] {"Sports", "Education",
			"Foods", "Arts", "Handy-Man", "IT Guy", "Fashion/Style"};
	JComboBox<String> comboBox1 = new JComboBox<String>(categories);

	final String[] columnNames = {"First Name",
			"Last Name",
			"Email",
			"Phone",
			"Price",
			"Talent",
	"Comment"};
	JPanel sortPanel;
	DefaultTableModel tableModel;

	/**
	 * Determine which GUI component an object is and if it is even one.
	 * @param obj an object that is a GUI component but it is unknown which one it is
	 * @return a {@link BoardComponentType} if it is one or INVALID_COMPONENT if not
	 */
	public AppState lookupComponentType(Object obj) {
		if (!componentMap.containsKey(obj)) {
			// If this object isn't a component on the GUI
			// it is an INVALID_COMPONENT
			return AppState.INVALID_COMPONENT;
		}
		return componentMap.get(obj);
	}

	/**
	 * Display the menu specified.
	 * It turns the current panel off and show the new one based on the button that was clicked
	 * @param panel the id of the panel to display
	 */
	public void setCurrentMenu(String panel) {

		if (panel.equalsIgnoreCase("service")){
			contentPane.getComponent(0).setVisible(false);
			contentPane.getComponent(3).setVisible(true);
		} else if (panel.equalsIgnoreCase("category")){
			contentPane.getComponent(0).setVisible(false);
			contentPane.getComponent(1).setVisible(true);
		}else if (panel.equalsIgnoreCase("back")){
			contentPane.getComponent(2).setVisible(false);
			contentPane.getComponent(1).setVisible(true);}
		else{
			contentPane.getComponent(3).setVisible(false);
			contentPane.getComponent(0).setVisible(true);
		}
	}

	/**
	 * Display the database specified.
	 * It turns the current panel off and show the new database based on the button clicked
	 * it does so by searching the database with the category selected and change the model 
	 * to a database of that specified category
	 * @param panel
	 */
	public void setCatView(String panel) {

		if (panel.equalsIgnoreCase("IT")){
			HMOProfile[] searchArray = new HMOProfile[model.profilesArray.length];
			contentPane.getComponent(1).setVisible(false);
			searchArray = new HMOProfile[model.profilesArray.length];
			model.search("IT Guy");

			MergeX.sort(model.profilesArray,HMOProfile.PriceComparator);
			searchArray = model.profilesArray;
			model.setData(searchArray,model.getData());

			database = new JTable(model.getData(), columnNames);
			scrollPane1.setViewportView(database);
			contentPane.getComponent(2).repaint();
			contentPane.getComponent(2).setVisible(true);
		}

		if (panel.equalsIgnoreCase("sports")){
			HMOProfile[] searchArray = new HMOProfile[model.profilesArray.length];
			contentPane.getComponent(1).setVisible(false);
			searchArray = new HMOProfile[model.profilesArray.length];
			model.search("Sports");
			MergeX.sort(model.profilesArray,HMOProfile.PriceComparator);
			searchArray = model.profilesArray;
			model.setData(searchArray,model.getData());
			//system.out.println(Arrays.toString(model.profilesArray));
			database = new JTable(model.getData(), columnNames);
			scrollPane1.setViewportView(database);
			contentPane.getComponent(2).repaint();
			contentPane.getComponent(2).setVisible(true);
		}

		if (panel.equalsIgnoreCase("edu")){
			HMOProfile[] searchArray = new HMOProfile[model.profilesArray.length];
			contentPane.getComponent(1).setVisible(false);
			searchArray = new HMOProfile[model.profilesArray.length];
			model.search("Education");
			MergeX.sort(model.profilesArray,HMOProfile.PriceComparator);
			searchArray = model.profilesArray;
			model.setData(searchArray,model.getData());
			//System.out.println(Arrays.toString(model.profilesArray));
			database = new JTable(model.getData(), columnNames);
			scrollPane1.setViewportView(database);
			contentPane.getComponent(2).repaint();
			contentPane.getComponent(2).setVisible(true);
		}

		if (panel.equalsIgnoreCase("fashion")){
			HMOProfile[] searchArray = new HMOProfile[model.profilesArray.length];
			contentPane.getComponent(1).setVisible(false);
			searchArray = new HMOProfile[model.profilesArray.length];
			model.search("Fashion");
			MergeX.sort(model.profilesArray,HMOProfile.PriceComparator);
			searchArray = model.profilesArray;
			model.setData(searchArray,model.getData());
			//System.out.println(Arrays.toString(model.profilesArray));
			database = new JTable(model.getData(), columnNames);
			scrollPane1.setViewportView(database);
			contentPane.getComponent(2).repaint();
			contentPane.getComponent(2).setVisible(true);
		}

		if (panel.equalsIgnoreCase("handy")){
			HMOProfile[] searchArray = new HMOProfile[model.profilesArray.length];
			contentPane.getComponent(1).setVisible(false);
			searchArray = new HMOProfile[model.profilesArray.length];
			model.search("Handy Man");
			MergeX.sort(model.profilesArray,HMOProfile.PriceComparator);
			searchArray = model.profilesArray;
			model.setData(searchArray,model.getData());
			//System.out.println(Arrays.toString(model.profilesArray));
			database = new JTable(model.getData(), columnNames);
			scrollPane1.setViewportView(database);
			contentPane.getComponent(2).repaint();
			contentPane.getComponent(2).setVisible(true);
		}

		if (panel.equalsIgnoreCase("foods")){
			HMOProfile[] searchArray = new HMOProfile[model.profilesArray.length];
			contentPane.getComponent(1).setVisible(false);
			searchArray = new HMOProfile[model.profilesArray.length];
			model.search("Foods");
			MergeX.sort(model.profilesArray,HMOProfile.PriceComparator);
			searchArray = model.profilesArray;
			model.setData(searchArray,model.getData());
			//System.out.println(Arrays.toString(model.profilesArray));
			database = new JTable(model.getData(), columnNames);
			scrollPane1.setViewportView(database);
			contentPane.getComponent(2).repaint();
			contentPane.getComponent(2).setVisible(true);

		}

		if (panel.equalsIgnoreCase("arts")){
			HMOProfile[] searchArray = new HMOProfile[model.profilesArray.length];
			contentPane.getComponent(1).setVisible(false);
			searchArray = new HMOProfile[model.profilesArray.length];
			model.search("arts");
			MergeX.sort(model.profilesArray,HMOProfile.PriceComparator);
			searchArray = model.profilesArray;
			model.setData(searchArray,model.getData());
			//System.out.println(Arrays.toString(model.profilesArray));
			database = new JTable(model.getData(), columnNames);
			scrollPane1.setViewportView(database);
			contentPane.getComponent(2).repaint();
			contentPane.getComponent(2).setVisible(true);
			//System.out.println("This is this button G");
		}

		if (panel.equalsIgnoreCase("all")){
			HMORecords all = null;
			try {
				all = new HMORecords();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HMOProfile[] searchArray = new HMOProfile[all.profilesArray.length];
			contentPane.getComponent(1).setVisible(false);
			searchArray = new HMOProfile[all.profilesArray.length];
			MergeX.sort(all.profilesArray,HMOProfile.PriceComparator);
			searchArray = all.profilesArray;

			model.setData(searchArray,all.getData());
			model.setProfileArray(searchArray);
			database = new JTable(all.getData(), columnNames);
			scrollPane1.setViewportView(database);
			contentPane.getComponent(2).repaint();
			contentPane.getComponent(2).setVisible(true);
		}

	}

	/**
	 * Display the database specified.
	 * It turns the current panel off and show the new database based on the button clicked
	 *  it does so by sorting the database with the field selected and changes the model 
	 * to a database of that specified sorted field
	 * @param sort
	 * @param counter
	 */
	public void setDataView(String sort,int counter){

		HMOProfile[] sortArray = new HMOProfile[model.profilesArray.length];

		if (sort.equalsIgnoreCase("firstN")){
			if((counter % 2) == 0){
				contentPane.getComponent(2).setVisible(false);
				sortArray = new HMOProfile[model.profilesArray.length];
				model.sortFirstName();
				sortArray = model.profilesArray;
				model.setData(sortArray,model.getData());
				database = new JTable(model.getData(), columnNames);
				scrollPane1.setViewportView(database);
				contentPane.getComponent(2).repaint();
				contentPane.getComponent(2).setVisible(true);}
			else {
				contentPane.getComponent(2).setVisible(false);
				sortArray = new HMOProfile[model.profilesArray.length];
				model.flipData();
				sortArray = model.profilesArray;
				model.setData(sortArray,model.getData());
				database = new JTable(model.getData(), columnNames);
				scrollPane1.setViewportView(database);
				contentPane.getComponent(2).repaint();
				contentPane.getComponent(2).setVisible(true);
			}
		}

		if (sort.equalsIgnoreCase("lastN")){
			if((counter % 2) == 0){
				contentPane.getComponent(2).setVisible(false);
				sortArray = new HMOProfile[model.profilesArray.length];
				model.sortLastName();
				sortArray = model.profilesArray;
				model.setData(sortArray,model.getData());
				database = new JTable(model.getData(), columnNames);
				scrollPane1.setViewportView(database);
				contentPane.getComponent(2).repaint();
				contentPane.getComponent(2).setVisible(true);}
			else {
				contentPane.getComponent(2).setVisible(false);
				sortArray = new HMOProfile[model.profilesArray.length];
				model.flipData();
				sortArray = model.profilesArray;
				model.setData(sortArray,model.getData());
				database = new JTable(model.getData(), columnNames);
				scrollPane1.setViewportView(database);
				contentPane.getComponent(2).repaint();
				contentPane.getComponent(2).setVisible(true);
			}

		}
		if (sort.equalsIgnoreCase("price")){
			if((counter % 2) == 0){
				contentPane.getComponent(2).setVisible(false);
				sortArray = new HMOProfile[model.profilesArray.length];
				model.sortPrice();
				sortArray = model.profilesArray;
				model.setData(sortArray,model.getData());
				database = new JTable(model.getData(), columnNames);
				scrollPane1.setViewportView(database);
				contentPane.getComponent(2).repaint();
				contentPane.getComponent(2).setVisible(true);}
			else {
				contentPane.getComponent(2).setVisible(false);
				sortArray = new HMOProfile[model.profilesArray.length];
				//model.sortLastName();
				model.flipData();
				sortArray = model.profilesArray;
				model.setData(sortArray,model.getData());
				database = new JTable(model.getData(), columnNames);
				scrollPane1.setViewportView(database);
				contentPane.getComponent(2).repaint();
				contentPane.getComponent(2).setVisible(true);
			}
		}
		if (sort.equalsIgnoreCase("phone")){
			if((counter % 2) == 0){
				contentPane.getComponent(2).setVisible(false);
				sortArray = new HMOProfile[model.profilesArray.length];
				model.sortPhone();
				sortArray = model.profilesArray;
				model.setData(sortArray,model.getData());
				database = new JTable(model.getData(), columnNames);
				scrollPane1.setViewportView(database);
				contentPane.getComponent(2).repaint();
				contentPane.getComponent(2).setVisible(true);}
			else {
				contentPane.getComponent(2).setVisible(false);
				sortArray = new HMOProfile[model.profilesArray.length];
				//model.sortLastName();
				model.flipData();
				sortArray = model.profilesArray;
				model.setData(sortArray,model.getData());
				database = new JTable(model.getData(), columnNames);
				scrollPane1.setViewportView(database);
				contentPane.getComponent(2).repaint();
				contentPane.getComponent(2).setVisible(true);
			}
		}
		if (sort.equalsIgnoreCase("email")){
			if((counter % 2) == 0){
				contentPane.getComponent(2).setVisible(false);
				sortArray = new HMOProfile[model.profilesArray.length];
				model.sortEmail();
				sortArray = model.profilesArray;
				model.setData(sortArray,model.getData());
				database = new JTable(model.getData(), columnNames);
				scrollPane1.setViewportView(database);
				contentPane.getComponent(2).repaint();
				contentPane.getComponent(2).setVisible(true);}
			else {
				contentPane.getComponent(2).setVisible(false);
				sortArray = new HMOProfile[model.profilesArray.length];
				//model.sortLastName();
				model.flipData();
				sortArray = model.profilesArray;
				model.setData(sortArray,model.getData());
				database = new JTable(model.getData(), columnNames);
				scrollPane1.setViewportView(database);
				contentPane.getComponent(2).repaint();
				contentPane.getComponent(2).setVisible(true);
			}
		}
		if (sort.equalsIgnoreCase("talent")){
			if((counter % 2) == 0){
				contentPane.getComponent(2).setVisible(false);
				sortArray = new HMOProfile[model.profilesArray.length];
				model.sortTalent();
				sortArray = model.profilesArray;
				model.setData(sortArray,model.getData());
				database = new JTable(model.getData(), columnNames);
				scrollPane1.setViewportView(database);
				contentPane.getComponent(2).repaint();
				contentPane.getComponent(2).setVisible(true);}
			else {
				contentPane.getComponent(2).setVisible(false);
				sortArray = new HMOProfile[model.profilesArray.length];
				//model.sortLastName();
				model.flipData();
				sortArray = model.profilesArray;
				model.setData(sortArray,model.getData());
				database = new JTable(model.getData(), columnNames);
				scrollPane1.setViewportView(database);
				contentPane.getComponent(2).repaint();
				contentPane.getComponent(2).setVisible(true);
			}
		}
	}
	/**
	 * Display the database specified.
	 *  it does so by sorting the database with the field selected and changes the model 
	 *  * it does so by searching the database with the keyword searched and change the model 
	 * to a database of that specified search
	 * @param search
	 */
	public void setSearchView(String search) {

		HMOProfile[] searchArray = new HMOProfile[model.profilesArray.length];
		try {
			contentPane.getComponent(1).setVisible(false);
		} catch (IllegalComponentStateException e) {
			// TODO: handle exception
		}
		searchArray = new HMOProfile[model.profilesArray.length];
		model.search(search);
		MergeX.sort(model.profilesArray,HMOProfile.PriceComparator);
		searchArray = model.profilesArray;
		model.setData(searchArray,model.getData());
		model.setProfileArray(searchArray);
		database = new JTable(model.getData(), columnNames);
		scrollPane1.setViewportView(database);
		contentPane.getComponent(2).repaint();
		contentPane.getComponent(2).setVisible(true);
	}
}

