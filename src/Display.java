
//import statements
import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.IOException;

import javax.swing.border.Border;

import jdk.jfr.ContentType;
import org.jfree.chart.ChartPanel;

public class Display implements ActionListener{
	static JMenuBar menuBar;
    static JMenu menu;
    static JLabel dateTime;
    static JMenuItem menuLogoff, menuDelete;//, placeholder;
    private JFrame frame;
    private String username; //used to track username
    private String[] user = new String[20];
    
    //Panel 1 - left top - Current stats, ht, wt, GOAL
    private JPanel currentStatsPanel;
    private JLabel heightLabel;
    private JTextField heightText = new JTextField();
    private JLabel weightLabel;
    private JTextField weightText = new JTextField();
    private JLabel goalLabel;
    private JTextField goalText = new JTextField();
    
    //panel 2 - left bottom - goal, gender radio, weight text, 
    	//height text, age, activity level, goal, update button
    private JPanel currentGoalPanel;
    private JLabel genderLabel;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup genderGroup;
    private JLabel currentWeightLabel;
    private JTextField currentWeightText;
    private JLabel currentHeightLabel;
    private JTextField currentHeightText;
    private JLabel ageLabel;
    private JTextField ageText;
    private JLabel goalWeightLabel;
    private JTextField goalWeightText;
    private JLabel activityLabel;
    private JRadioButton sedentary;
    private JRadioButton lightActive;
    private JRadioButton modActive;
    private JRadioButton veryActive;
    private JRadioButton extraActive;
    private ButtonGroup actyLvlGroup;
    private JButton updateGoalBtn;
    private JButton clearGoalBtn;
    private JRadioButton reset_activity_level;
    private JRadioButton reset_gender;
    
    //panel 3 - right top - PROGRESS CHART
    private ChartPanel chartPanel = null;
    private Chart chart;


    //panel 4 - right bottom - goal analysis string. 
    private JPanel analysisPanel;
    private JTextArea analysisArea = new JTextArea();
    
public Display(String username) {
	int HORIZSPLIT = JSplitPane.HORIZONTAL_SPLIT;
	int VERTSPLIT = JSplitPane.VERTICAL_SPLIT;
    boolean GridBagLayout = true;
    this.username = username;

    try {
        DatabaseInterface DB = new DatabaseInterface();
        user = DB.get_bios(username);
    } catch (IOException e) {
        frame.dispose(); //if there is an error we die
    }

    Border statBorder = BorderFactory.createTitledBorder("Current Statistics");

    currentStatsPanel = new JPanel(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.HORIZONTAL;
    
    heightLabel = new JLabel("Height: ");
    constraints.insets = new Insets(2,2,2,2);
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.gridwidth = 1;
    currentStatsPanel.add(heightLabel, constraints);

    heightText.setText(user[0]); // = new JTextField(user[0]);
    heightText.setEditable(false);
    constraints.insets = new Insets(2,2,2,2);
    constraints.gridx = 1;
    constraints.gridy = 0;
    constraints.gridwidth = 1;
    currentStatsPanel.add(heightText, constraints);
    
    weightLabel = new JLabel("Weight: ");
    constraints.insets = new Insets(2,2,2,2);
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.gridwidth = 1;
    currentStatsPanel.add(weightLabel, constraints);

    weightText.setText(user[1]); // = new JTextField(user[1]);
    weightText.setEditable(false);
    constraints.insets = new Insets(2,2,2,2);
    constraints.gridx = 1;
    constraints.gridy = 1;
    constraints.gridwidth = 1;
    currentStatsPanel.add(weightText, constraints);


    goalLabel = new JLabel("GOAL: ");
    constraints.insets = new Insets(2,2,2,2);
    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.gridwidth = 1;
    currentStatsPanel.add(goalLabel, constraints);

    goalText.setText(user[5]); //= new JTextField(user[5]);
    goalText.setEditable(false);
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 1;
    constraints.gridy = 2;
    constraints.gridwidth = 1;
    currentStatsPanel.add(goalText, constraints);
    
    currentStatsPanel.setBorder(statBorder);

    //Start Panel 2
    Border goalBorder = BorderFactory.createTitledBorder("GOAL Updates");
    
    currentGoalPanel = new JPanel(new GridBagLayout());
    constraints.fill = GridBagConstraints.HORIZONTAL;
    
    genderLabel = new JLabel("Gender: ");
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 0;
    constraints.gridy = 0;
    currentGoalPanel.add(genderLabel, constraints);
    
    male = new JRadioButton("Male");
    female = new JRadioButton("Female");
    reset_gender = new JRadioButton();
    genderGroup = new ButtonGroup();
    genderGroup.add(male);
    genderGroup.add(female);
    genderGroup.add(reset_gender);
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 1;
    constraints.gridy = 0;
    currentGoalPanel.add(male, constraints);
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 1;
    constraints.gridy = 1;
    currentGoalPanel.add(female, constraints);
    
    currentWeightLabel = new JLabel("Current Weight: (lbs)");
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.gridwidth = 1;
    currentGoalPanel.add(currentWeightLabel, constraints);

    currentWeightText = new JTextField();
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 1;
    constraints.gridy = 2;
    constraints.gridwidth = 1;
    currentGoalPanel.add(currentWeightText, constraints);
    
    currentHeightLabel = new JLabel("Current Height: (inch)");
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 0;
    constraints.gridy = 3;
    constraints.gridwidth = 1;
    currentGoalPanel.add(currentHeightLabel, constraints);

    currentHeightText = new JTextField();
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 1;
    constraints.gridy = 3;
    constraints.gridwidth = 1;
    currentGoalPanel.add(currentHeightText, constraints);
    
    ageLabel = new JLabel("Age: (yrs)");
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 0;
    constraints.gridy = 4;
    constraints.gridwidth = 1;
    currentGoalPanel.add(ageLabel, constraints);

    ageText = new JTextField();
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 1;
    constraints.gridy = 4;
    constraints.gridwidth = 1;
    currentGoalPanel.add(ageText, constraints);
    
    goalWeightLabel = new JLabel("GOAL Weight: (lbs)");
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 0;
    constraints.gridy = 5;
    constraints.gridwidth = 1;
    currentGoalPanel.add(goalWeightLabel, constraints);

    goalWeightText = new JTextField();
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 1;
    constraints.gridy = 5;
    constraints.gridwidth = 1;
    currentGoalPanel.add(goalWeightText, constraints);
    
    activityLabel = new JLabel("Activity Level: ");
    constraints.insets = new Insets(1,1,1,1);
    constraints.gridx = 0;
    constraints.gridy = 6;
    constraints.gridwidth = 1;
    currentGoalPanel.add(activityLabel, constraints);
    
    sedentary = new JRadioButton("Sedentary");
    lightActive = new JRadioButton("Light Active");
    modActive = new JRadioButton("Moderate Active");
    veryActive = new JRadioButton("Very Active");
    extraActive = new JRadioButton("Extra Active");
    reset_activity_level = new JRadioButton();
    actyLvlGroup = new ButtonGroup();
    actyLvlGroup.add(sedentary);
    actyLvlGroup.add(lightActive);
    actyLvlGroup.add(modActive);
    actyLvlGroup.add(veryActive);
    actyLvlGroup.add(extraActive);
    actyLvlGroup.add(reset_activity_level);
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 1;
    constraints.gridy = 6;
    constraints.gridwidth = 2;
    currentGoalPanel.add(sedentary, constraints);
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 1;
    constraints.gridy = 7;
    constraints.gridwidth = 2;
    currentGoalPanel.add(lightActive, constraints);
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 1;
    constraints.gridy = 8;
    constraints.gridwidth = 2;
    currentGoalPanel.add(modActive, constraints);
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 1;
    constraints.gridy = 9;
    constraints.gridwidth = 2;
    currentGoalPanel.add(veryActive, constraints);
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 1;
    constraints.gridy = 10;
    constraints.gridwidth = 2;
    currentGoalPanel.add(extraActive, constraints);
    
    updateGoalBtn = new JButton("Update");
    updateGoalBtn.addActionListener(this);
    constraints.insets = new Insets(0,0,0,0);
    constraints.gridx = 1;
    constraints.gridy = 11;
    constraints.gridwidth = 1;
    currentGoalPanel.add(updateGoalBtn, constraints);

    
    clearGoalBtn = new JButton("Clear");
    constraints.insets = new Insets(5,5,5,5);
    constraints.gridx = 2;
    constraints.gridy = 11;
    clearGoalBtn.addActionListener(this); 
    currentGoalPanel.add(clearGoalBtn, constraints);
    currentGoalPanel.setBorder(goalBorder);

    //Start Panel 3
    chart = new Chart("Progress Chart" , "Days", "Weight", user);
    chartPanel = new ChartPanel(chart.createchart());
    chartPanel.setPreferredSize(new java.awt.Dimension(350,350));
	
	//Forth Panel
	Border analysisBorder = BorderFactory.createTitledBorder("Goal Analysis");
	analysisPanel = new JPanel();
	Calculation c = new Calculation(user);
    analysisArea.setText(c.calc_weight_goal()); //= new JTextArea(c.calc_weight_goal());
	analysisArea.setSize(360, 100); //modify the height from 100, if need more room!
	analysisArea.setLineWrap(true);
	analysisArea.setEditable(false);
	analysisPanel.add(analysisArea);
	//Add the goal analysis string to the panel!
	analysisPanel.setBorder(analysisBorder);
	
	//JSplitPane splitPane1 = new JSplitPane(VERTSPLIT, GridBagLayout, label1, label2);
	JSplitPane splitPane1 = new JSplitPane(VERTSPLIT, GridBagLayout, currentStatsPanel, currentGoalPanel);
	splitPane1.setOneTouchExpandable(true);
	splitPane1.setDividerSize(2);
	splitPane1.setDividerLocation(100);//set the left most panel, default (0.5)
	JSplitPane splitPane2 = new JSplitPane(VERTSPLIT, GridBagLayout, chartPanel, analysisPanel); //chartPanel is added directly to frame to fill area
	splitPane2.setOneTouchExpandable(true);
	splitPane2.setDividerSize(2);
	splitPane2.setDividerLocation(250);//set the right most panel, default (0.5)
	
	JSplitPane splitPane3 = new JSplitPane(HORIZSPLIT, splitPane1, splitPane2);
	splitPane3.setOneTouchExpandable(true);
	splitPane3.setDividerLocation(300); //set the center divider, default (0.4)
	splitPane3.setDividerSize(2);
	
	//menu bar
	menuBar = new JMenuBar();
	menu = new JMenu("Menu");
	// create menu items
    menuLogoff = new JMenuItem("Log Off");
    menuDelete = new JMenuItem("Delete Profile");
    //placeholder = new JMenuItem("placeholder");
    
    
    //Log off terminates program as soon as the user clicks
    menuLogoff.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
            System.exit(0);
        }//end action

    });//end menuLogoff ActionListener
   
    //delete will spawn a JOptionPane that asks the sure if they are sure
    menuDelete.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
            			JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                //yes option
            	//need to add database logic here!!!
                //Todd added code to delete user
                try {
                    DatabaseInterface DB = new DatabaseInterface();
                    DB.delete_user(username);
                }catch (IOException e){
                    JOptionPane.showMessageDialog(null, "Error Deleting Profile. \n Goodbye!",
                            "Alert", JOptionPane.WARNING_MESSAGE); //display error and closing application
                }finally{
                    System.exit(0);
                }

            	JOptionPane.showMessageDialog(null,"Successfully Deleted Profile. \nGoodbye!","Alert",
            			JOptionPane.WARNING_MESSAGE);
            	System.exit(0);
                } else {
                 // no option
                }
            }//end action
    });//end menuLogoff ActionListener
    
    //add date
    LocalDateTime myDateObj = LocalDateTime.now();  
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy"); 
    //.ofPattern("E, MMM dd yyyy HH:mm:ss");  if we want a static time
    //if we want dynamic we make into a thread!
    String formattedDate = myDateObj.format(myFormatObj); 
   
    dateTime = new JLabel(" " + formattedDate);
	//JMenu components
	menu.add(menuLogoff);
    menu.add(menuDelete);
    //menu.add(placeholder); //can delete if we DO NOT NEED
    menuBar.add(menu);
    menuBar.add(dateTime); //Update with local time
	
    //JFrame components
	frame = new JFrame("Health Monitoring UI");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(splitPane3);
    frame.setJMenuBar(menuBar);
	frame.setSize(700, 500);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	}//end Display()


	@Override
	public void actionPerformed(ActionEvent e) {
        //ensure radio buttons from both fields are selected when update button is pressed.
        // otherwise bad things will likely happen and we really don't want to have to deal with that.
		if (e.getSource() == clearGoalBtn) {
            clearFields();
	    }
		else if (e.getSource() == updateGoalBtn) {

		    boolean input_correct = true;
		    while (input_correct) {
                //set variables to UI input
                String currentHeight = currentHeightText.getText();
                String currentWeight = currentWeightText.getText();
                String currentAge = ageText.getText();
                String goalWeight = goalWeightText.getText();

                /**
                 * input type validation for GOAL Updates
                 *
                 */
                    //currenHeight
                if (!(currentHeight.matches("([\\d])+")) && (!(currentHeight.matches("")))) {
                    System.out.println("inside where i shouldn't be: " + currentHeight);
                    JOptionPane.showMessageDialog(null, "You did not enter a numerical value in the Current Height field", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                    clearFields();
                    break;
                    //currentWeight
                } else if (!(currentWeight.matches("([\\d])+")) && (!(currentWeight.matches("")))) {
                    System.out.println("inside where i shouldn't be: " + currentHeight);
                    JOptionPane.showMessageDialog(null, "You did not enter a numerical value in the Current Weight field", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                    clearFields();
                    break;
                    //currentAge
                } else if (!(currentAge.matches("([\\d])+")) && (!(currentAge.matches("")))) {
                    System.out.println("inside where i shouldn't be: " + currentHeight);
                    JOptionPane.showMessageDialog(null, "You did not enter a numerical value in the Age field", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                    clearFields();
                    break;
                    //goalWeight
                } else if (!(goalWeight.matches("([\\d])+")) && (!(goalWeight.matches("")))) {
                    System.out.println("inside where i shouldn't be: " + currentHeight);
                    JOptionPane.showMessageDialog(null, "You did not enter a numerical value in the GOAL Weight field", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                    clearFields();
                    break;
                }

                String gender;
                if (male.isSelected())
                    gender = "Male";
                else if (female.isSelected())
                    gender = "Female";
                else
                    gender = "Gender Not Selected";

                String activity;
                if (sedentary.isSelected())
                    activity = "Sedentary";
                else if (lightActive.isSelected())
                    activity = "Light_Activity";
                else if (modActive.isSelected())
                    activity = "Moderate_Activity";
                else if (veryActive.isSelected())
                    activity = "Very_Active";
                else if (extraActive.isSelected())
                    activity = "Extra_Active";
                else
                    activity = "Activity Not Selected";

                //if variable is not blank set to bios array
                if (!currentHeight.equals(""))
                    user[0] = currentHeight;
                if (!currentWeight.equals("")) {
                    user = shuffleWeight(user);
                    user[1] = currentWeight;
                    user[19] = user[1];
                }
                if (!currentAge.equals(""))
                    user[2] = currentAge;
                if (gender.equals("Female") || gender.equals("Male"))
                    user[3] = gender;
                if (!activity.equals("Activity Not Selected"))
                    user[4] = activity;
                if (!goalWeight.equals(""))
                    user[5] = goalWeight;

                try {
                    //connect to DB
                    DatabaseInterface DB = new DatabaseInterface();
                    //push bios to DB
                    DB.update_bios(username, user);
                    input_correct = false;
                    update();
                    clearFields();

                } catch (IOException e1) {
                    //if we catch an IOException, we alert user and clear the fields.
                    JOptionPane.showMessageDialog(null, "Problem Updating Profile. \nGoodbye!", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                    input_correct = false;
                    clearFields();

                }//end catch
            }//end while loop
		}//end else if
	}//end action event

    public String [] shuffleWeight(String [] arrayToShuffle){
        for (int i=0; i<=12; i++)
            arrayToShuffle[i+6] = arrayToShuffle[i+7];

        return arrayToShuffle;
    }
    //clear fields helper method
    private void clearFields(){
        String erase = "";
        currentHeightText.setText(erase);
        currentWeightText.setText(erase);
        goalWeightText.setText(erase);
        ageText.setText(erase);
        reset_gender.setSelected(true);
        reset_activity_level.setSelected(true);
    }
    // updates the fields, chat and chlculation
    private void update(){
        heightText.setText(user[0]);
        weightText.setText(user[1]);
        goalText.setText(user[5]);

        Calculation c = new Calculation(user);
        analysisArea.setText(c.calc_weight_goal());

        chart.update(user);

    }
}//end Display()
