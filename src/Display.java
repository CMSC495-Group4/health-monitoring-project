//import statements
import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.border.Border;

public class Display implements ActionListener{
	static JMenuBar menuBar;
    static JMenu menu;
    static JLabel dateTime;
    static JMenuItem menuLogoff, menuDelete;//, placeholder;
    private JFrame frame;
    
    //Panel 1 - left top - Current stats, ht, wt, GOAL
    private JPanel currentStatsPanel;
    private JLabel heightLabel;
    private JTextField heightText;
    private JLabel weightLabel;
    private JTextField weightText;
    private JLabel goalLabel;
    private JTextField goalText;
    
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
    
    //panel 3 - right top - PROGRESS CHART
    private JPanel progressPanel;
    
    
    //panel 4 - right bottom - goal analysis string. 
    private JPanel analysisPanel;
    private JTextArea analysisArea;
    
public Display() {
	int HORIZSPLIT = JSplitPane.HORIZONTAL_SPLIT;
	int VERTSPLIT = JSplitPane.VERTICAL_SPLIT;
	boolean GridBagLayout = true;
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

    heightText = new JTextField("toString");
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

    weightText = new JTextField("toString");
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

    goalText = new JTextField("toString");
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
    genderGroup = new ButtonGroup();
    genderGroup.add(male);
    genderGroup.add(female);
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
    actyLvlGroup = new ButtonGroup();
    actyLvlGroup.add(sedentary);
    actyLvlGroup.add(lightActive);
    actyLvlGroup.add(modActive);
    actyLvlGroup.add(veryActive);
    actyLvlGroup.add(extraActive);
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
    Border chartBorder = BorderFactory.createTitledBorder("Progress Chart");
	progressPanel = new JPanel();
	//add chart to the panel!
	progressPanel.setBorder(chartBorder);
	
	//Forth Panel
	Border analysisBorder = BorderFactory.createTitledBorder("Goal Analysis");
	analysisPanel = new JPanel();
	analysisArea = new JTextArea("add the analysis string here!");
	analysisArea.setLineWrap(true);
	analysisArea.setEditable(false);
	analysisPanel.add(analysisArea);
	//Add the goal analysis string to the panel!
	analysisPanel.setBorder(analysisBorder);
	
	
    //test labels
	//JLabel label1 = new JLabel("a");
	//JLabel label2 = new JLabel("b");
	//JLabel label3 = new JLabel("c");
	//JLabel label4 = new JLabel("d");
	
	
	//JSplitPane splitPane1 = new JSplitPane(VERTSPLIT, GridBagLayout, label1, label2);
	JSplitPane splitPane1 = new JSplitPane(VERTSPLIT, GridBagLayout, currentStatsPanel, currentGoalPanel);
	splitPane1.setOneTouchExpandable(true);
	splitPane1.setDividerSize(2);
	splitPane1.setDividerLocation(100);//set the left most panel, default (0.5)
	JSplitPane splitPane2 = new JSplitPane(VERTSPLIT, GridBagLayout, progressPanel, analysisPanel);
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
   
    //delete will spawn a JOptionPane that asks the suer if they are sure
    menuDelete.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
            			JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                //yes option
            	//need to add database logic here!!!
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
	frame.setSize(600, 500);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	}//end Display()

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clearGoalBtn) {
	        String erase = ""; 
	        currentHeightText.setText(erase);
	        currentWeightText.setText(erase);
	        goalWeightText.setText(erase);
	        ageText.setText(erase);
	    }
		else if (e.getSource() == updateGoalBtn) {
			//add functionality here!!!
		}//end else if
	}//end action event
}//end Display()