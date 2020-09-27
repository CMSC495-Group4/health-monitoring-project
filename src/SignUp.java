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
    private JTextField passwordText; // OR to char-out use JPasswordField;
    private JLabel rePasswordLabel;
    private JTextField rePasswordText; // OR to char-out use JPasswordField;

    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup genderGroup;

    private JLabel ageLabel;
    private JTextField ageText;

    private JLabel activityLabel;
    private JRadioButton sedentary;
    private JRadioButton lightActive;
    private JRadioButton modActive;
    private JRadioButton veryActive;
    private JRadioButton extraActive;
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
        passwordText = new JTextField();
        passwordText.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordText.setSize(200, 20);
        passwordText.setLocation(200, 150);
        c.add(passwordText);

        rePasswordLabel = new JLabel("Re-Enter:");
        rePasswordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        rePasswordLabel.setSize(200, 20);
        rePasswordLabel.setLocation(100, 175);
        c.add(rePasswordLabel);

        rePasswordText = new JTextField();
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

        genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

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
        actyLvlGroup = new ButtonGroup();
        actyLvlGroup.add(sedentary);
        actyLvlGroup.add(lightActive);
        actyLvlGroup.add(modActive);
        actyLvlGroup.add(veryActive);
        actyLvlGroup.add(extraActive);

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
            if (term.isSelected()) {
                String data1;
                String data = "Username: " + usernameText.getText() + "\n" + "Password Match: " + passwordText.getText()
                        + "\n";
                if (male.isSelected())
                    data1 = "Male" + "\n";
                else if (female.isSelected())
                    data1 = "Female" + "\n";
                else
                    data1 = "Gender: " + "\n";

                String data2 = "Age : " + ageText.getText() + "\n";
                String data3 = "Current Height: " + heightText.getText() + "\n";
                String data4 = "Current Weight: " + weightText.getText() + "\n";
                String data5;
                if (sedentary.isSelected())
                    data5 = "Sedentary" + "\n";
                else if (lightActive.isSelected())
                    data5 = "Light Activity" + "\n";
                else if (modActive.isSelected())
                    data5 = "Moderate Activity" + "\n";
                else if (veryActive.isSelected())
                    data5 = "Very Active" + "\n";
                else if (extraActive.isSelected())
                    data5 = "Extra Active" + "\n";
                else
                    data5 = "Activity Level: " + "\n";
                String data6 = "Goal Weight: " + goalWeightText.getText() + "\n";
                String data7;
                if (term.isSelected())
                    data7 = "Terms and Conditions: True" + "\n";
                else
                    data7 = "Terms and Conditions: False" + "\n";
                tout.setText(data + data1 + data2 + data3 + data4 + data5 + data6 + data7);
                tout.setEditable(false);
                String[] bios = new String[] {heightText.getText(),weightText.getText(),ageText.getText(),data1,data5,goalWeightText.getText()};
                try {
                    DatabaseInterface new_user = new DatabaseInterface();
                    //new_user.user_exists(usernameText.getText());  //TODO need to add logic to see if user already exists
                    new_user.add_user(usernameText.getText(), passwordText.getText(), bios);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                res.setText("Profile successfully created..."); 
                final Timer t = new Timer(10000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        dispose();
                        Login run_login_gui = new Login();
                    }
                });
                t.setRepeats(false);
                t.start();
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
            //NOTE The radio buttons do not reset even when
            //.setSelected(false); is assigned. 
            term.setSelected(false); 
            resadd.setText(erase); 
        }//end else if
    }//end ActionEvent
}//end SignUp()