// Java program to implement 
// a Simple Registration Form 
// using Java Swing 
  
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.io.IOException;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

class SignUp extends JFrame implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel usernameLabel;
    private JTextField usernameText;
    private JLabel passwordLabel;
    private JPasswordField passwordText; // OR to char-out use JPasswordField;
    private JLabel rePasswordLabel;
    private JPasswordField rePasswordText; // OR to char-out use JPasswordField;

    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private JRadioButton reset_gender;
    private ButtonGroup genderGroup;

    private JLabel ageLabel;
    private JTextField ageText;

    private JLabel activityLabel;
    private JRadioButton sedentary;
    private JRadioButton lightActive;
    private JRadioButton modActive;
    private JRadioButton veryActive;
    private JRadioButton extraActive;
    private JRadioButton reset_activity_level;
    private ButtonGroup actyLvlGroup;

    private JLabel heightLabel;
    private JTextField heightText;

    private JLabel weightLabel;
    private JTextField weightText;

    private JLabel goalWeightLabel;
    private JTextField goalWeightText;

    private JCheckBox term; // terms and conditions
    private JButton sub; // submit button
    private JButton reset; // reset button
    private JTextArea tout; // text out
    private JLabel res; // Successful check
    private JTextArea resadd;

    // add date and time
    private JLabel dateTime;

    // constructor, to initialize the components
    // with default values.
    public SignUp() {
        setTitle("Registration Form");
        setBounds(300, 90, 850, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        // add date
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
        // .ofPattern("E, MMM dd yyyy HH:mm:ss"); if we want a static time
        // if we want dynamic we make into a thread!
        String formattedDate = myDateObj.format(myFormatObj);

        dateTime = new JLabel(formattedDate);
        dateTime.setFont(new Font("Arial", Font.PLAIN, 25));
        dateTime.setSize(300, 30);
        dateTime.setLocation(5, 0);
        c.add(dateTime);

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 25));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        usernameLabel.setSize(200, 20);
        usernameLabel.setLocation(100, 100);
        c.add(usernameLabel);

        usernameText = new JTextField();
        usernameText.setFont(new Font("Arial", Font.PLAIN, 15));
        usernameText.setSize(200, 20);
        usernameText.setLocation(200, 100);
        c.add(usernameText);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLabel.setSize(200, 20);
        passwordLabel.setLocation(100, 150);
        c.add(passwordLabel);

        // add in logic to see if passwords match!!!!
        passwordText = new JPasswordField();
        passwordText.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordText.setSize(200, 20);
        passwordText.setLocation(200, 150);
        c.add(passwordText);

        rePasswordLabel = new JLabel("Re-Enter:");
        rePasswordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        rePasswordLabel.setSize(200, 20);
        rePasswordLabel.setLocation(100, 175);
        c.add(rePasswordLabel);

        rePasswordText = new JPasswordField();
        rePasswordText.setFont(new Font("Arial", Font.PLAIN, 15));
        rePasswordText.setSize(200, 20);
        rePasswordText.setLocation(200, 175);
        c.add(rePasswordText);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(200, 20);
        gender.setLocation(100, 215);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        // male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 215);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        // female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 215);
        c.add(female);

        reset_gender = new JRadioButton();
        c.add(reset_gender);

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(reset_gender);

        ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        ageLabel.setSize(200, 25);
        ageLabel.setLocation(100, 250);
        c.add(ageLabel);

        ageText = new JTextField();
        ageText.setFont(new Font("Arial", Font.PLAIN, 15));
        ageText.setSize(200, 20);
        ageText.setLocation(200, 250);
        c.add(ageText);

        heightLabel = new JLabel("Height:");
        heightLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        heightLabel.setSize(90, 25);
        heightLabel.setLocation(100, 300);
        c.add(heightLabel);

        heightText = new JTextField();
        heightText.setFont(new Font("Arial", Font.PLAIN, 15));
        heightText.setSize(50, 20);
        heightText.setLocation(200, 300);
        c.add(heightText);

        weightLabel = new JLabel("Weight:");
        weightLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        weightLabel.setSize(90, 25);
        weightLabel.setLocation(275, 300);
        c.add(weightLabel);

        weightText = new JTextField();
        weightText.setFont(new Font("Arial", Font.PLAIN, 15));
        weightText.setSize(50, 20);
        weightText.setLocation(350, 300);
        c.add(weightText);

        activityLabel = new JLabel("Activity Level");
        activityLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        activityLabel.setSize(180, 20);
        activityLabel.setLocation(230, 350);
        c.add(activityLabel);

        sedentary = new JRadioButton("Sedentary");
        sedentary.setFont(new Font("Arial", Font.PLAIN, 15));
        sedentary.setSize(100, 20);
        sedentary.setLocation(40, 375);
        c.add(sedentary);
        lightActive = new JRadioButton("Light");
        lightActive.setFont(new Font("Arial", Font.PLAIN, 15));
        lightActive.setSize(60, 20);
        lightActive.setLocation(140, 375);
        c.add(lightActive);
        modActive = new JRadioButton("Moderate");
        modActive.setFont(new Font("Arial", Font.PLAIN, 15));
        modActive.setSize(90, 20);
        modActive.setLocation(200, 375);
        c.add(modActive);
        veryActive = new JRadioButton("Very Active");
        veryActive.setFont(new Font("Arial", Font.PLAIN, 15));
        veryActive.setSize(98, 20);
        veryActive.setLocation(290, 375);
        c.add(veryActive);
        extraActive = new JRadioButton("Extra Active");
        extraActive.setFont(new Font("Arial", Font.PLAIN, 15));
        extraActive.setSize(105, 20);
        extraActive.setLocation(385, 375);
        c.add(extraActive);

        reset_activity_level = new JRadioButton();
        c.add(reset_activity_level);

        actyLvlGroup = new ButtonGroup();
        actyLvlGroup.add(sedentary);
        actyLvlGroup.add(lightActive);
        actyLvlGroup.add(modActive);
        actyLvlGroup.add(veryActive);
        actyLvlGroup.add(extraActive);
        actyLvlGroup.add(reset_activity_level);

        goalWeightLabel = new JLabel("Goal Weight:");
        goalWeightLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        goalWeightLabel.setSize(150, 25);
        goalWeightLabel.setLocation(202, 410);
        c.add(goalWeightLabel);

        goalWeightText = new JTextField();
        goalWeightText.setFont(new Font("Arial", Font.PLAIN, 15));
        goalWeightText.setSize(50, 20);
        goalWeightText.setLocation(330, 410);
        c.add(goalWeightText);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(155, 440);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 480);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 480);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 510);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {
            if (term.isSelected() && validateFields()) {
                String data1;
                String data = "Username: " + usernameText.getText() + "\n" + "Password Match: " + passwordText.getText()
                        + "\n";
                if (male.isSelected())
                    data1 = "Male";
                else if (female.isSelected())
                    data1 = "Female";
                else
                    data1 = "Gender: ";
                
                String data2 = "Age : " + ageText.getText();
                String data3 = "Current Height: " + heightText.getText();
                String data4 = "Current Weight: " + weightText.getText();
                String data5;
                if (sedentary.isSelected())
                    data5 = "Sedentary";
                else if (lightActive.isSelected())
                    data5 = "Light_Activity";
                else if (modActive.isSelected())
                    data5 = "Moderate_Activity";
                else if (veryActive.isSelected())
                    data5 = "Very_Active";
                else if (extraActive.isSelected())
                    data5 = "Extra_Active";
                else
                    data5 = "Activity Level: ";
                String data6 = "Goal Weight: " + goalWeightText.getText();
                String data7;
                if (term.isSelected())
                    data7 = "Terms and Conditions: True" + "\n";
                else
                    data7 = "Terms and Conditions: False" + "\n";
                //data == username/password, data1 == gender, data2 == age, data3 == height, data4 == weight, data5 == activity level, data6 == goal weight, data7 == terms&cond checked
                tout.setText(data +"\n"+ data1 +"\n"+ data2 +"\n"+ data3 +"\n"+ data4 +"\n"+ data5 +"\n"+ data6 +"\n"+ data7);
                tout.setEditable(false);
                //bios array indices 8-20 are reserved for historical GOAl data; index 21 included for .csv formatting
                String[] bios = new String[] {heightText.getText(), weightText.getText(), ageText.getText(), data1,
                        data5, goalWeightText.getText(), null, null, null, null, null, null, null, null, null, null,
                        null, null, null, null};
                try {
                    DatabaseInterface new_user = new DatabaseInterface();
                    if (new_user.user_exists(usernameText.getText()))
                        JOptionPane.showMessageDialog(null, "Username already exists.");
                    else if (! passwordText.getText().equals(rePasswordText.getText()))
                        JOptionPane.showMessageDialog(null, "Passwords do not match.");
                    else
                        new_user.add_user(usernameText.getText(), passwordText.getText(), bios);
                        res.setText("Profile successfully created...Returning to Login Page!"); 
                        final Timer t = new Timer(6000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent evt) {
                                dispose();
                                Login run_login_gui = new Login();
                            }
                        });
                        t.setRepeats(false);
                        t.start();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }  

            else { 
                tout.setText(""); 
                resadd.setText(""); 
                res.setText("Please accept the"
                            + " terms & conditions..."); 
            } 
        }
        else if (e.getSource() == reset) {
            String erase = ""; 
            usernameText.setText(erase); 
            passwordText.setText(erase); 
            rePasswordText.setText(erase); 
            ageText.setText(erase);
            heightText.setText(erase);
            weightText.setText(erase);
            goalWeightText.setText(erase);
            reset_activity_level.setSelected(true);
            reset_gender.setSelected(true);
            // male.setSelected(false);
            // female.setSelected(false);
            term.setSelected(false); 
            resadd.setText(erase); 
        }//end else if
    }//end ActionEvent

    public boolean validateFields() {
        if (! validateField( usernameText, "Please enter a username"))
            return false;
        else if (! validateField( passwordText, "Please enter a password"))
            return false;
        else if (! validateField(ageText, "Please enter age"))
            return false;
        else if (! validateInteger(ageText, "Please enter valid number for age"))
            return false;
        else if (! validateField(heightText, "Please enter height"))
            return false;
        else if (! validateInteger(heightText, "Please enter valid number for height"))
            return false;
        else if (! validateField(weightText, "Please enter weight"))
            return false;
        else if (! validateInteger(weightText, "Please enter valid number for weight"))
            return false;
        else if (! validateField(goalWeightText, "Please enter goal weight"))
            return false;
        else if (! validateInteger(goalWeightText, "Please enter valid number for goal weight"))
            return false;
        else if (!validateButton(female, "Please select your gender"))
        	  return false;
        else if(!validateButtonS(sedentary, "Please select your activity level"))
        	return false;
        else
            return true;
    }
    //function for the activity level buttons
    private boolean validateButtonS(JRadioButton b, String errormsg) {
        //begin activity leves
        if (sedentary.isSelected())
            return true;
        else if (lightActive.isSelected())
            return true;
        else if (modActive.isSelected())
            return true;
        else if (veryActive.isSelected())
            return true;
        else if (extraActive.isSelected())
            return true;
        else
        	return failedMess(b, errormsg);
    }
  
    //function for the gender type
    private boolean validateButton(JRadioButton b, String errormsg) {
        if (female.isSelected())
            return true;
        else if (male.isSelected())
            return true;
        else
        	return failedMess(b, errormsg);
    }

    //returned for both the activty and gender radio buttons
    private boolean failedMess(JRadioButton b, String errormsg) {
    	JOptionPane.showMessageDialog(null, errormsg);
        b.requestFocus();
		return false;
	}
  
    private boolean validateField(JTextField f, String errormsg) {
        if (f.getText().equals(""))
            return failedMessage(f, errormsg);
        else
            return true;
    }

    private boolean validateInteger(JTextField f, String errormsg) {
        try {
            int i = Integer.parseInt(f.getText());
            if (i>0)
                return true;
        } catch (Exception e) {
            //TODO: handle exception
        }
        return failedMessage(f, errormsg);
    }

    private boolean failedMessage(JTextField f, String errormsg) {
        JOptionPane.showMessageDialog(null, errormsg);
        f.requestFocus();
        return false;
    }
}//end SignUp()
