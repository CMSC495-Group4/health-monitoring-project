import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * Login class subsystem designed to prompt the user if they
 * want to login or sign up. The User name and Password is present 
 * for the user to type, Login with then authenticate them. The
 * signup button will bring them to the SignUp UI where the user 
 * can add all the required information and create their account. 
 * The main() method is located in Main.java
 */

public class Login extends JFrame implements ActionListener{
	/**
	 * Adding default serial number
	 */
	private static final long serialVersionUID = 1L;
	
	//add the JFrame components
	//labels and text fields
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameText;
	private JPasswordField passwordText;
	//add frame and panel
	private JFrame loginFrame;
	private JPanel loginPanel;
	//add buttons
	private JButton loginButton;
	private JButton signupButton;
	private JButton cancelButton;
	
	//add date and time to the menu bar
	static JMenuBar menuBar;
    static JMenu menu;
    static JLabel dateTime;
	
	//begin Login()
	public Login() {
		
		loginPanel = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		
		usernameLabel = new JLabel("Username: ");
		constraints.insets = new Insets(3,3,3,3); //set >3 if want larger spacing!
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
        loginPanel.add(usernameLabel, constraints);
 
        usernameText = new JTextField(15);
        constraints.insets = new Insets(3,3,3,3);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        loginPanel.add(usernameText, constraints);
 
        passwordLabel = new JLabel("Password: ");
        constraints.insets = new Insets(3,3,3,3);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        loginPanel.add(passwordLabel, constraints);
 
        passwordText = new JPasswordField(15);
        constraints.insets = new Insets(3,3,3,3);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        loginPanel.add(passwordText, constraints);
       
        loginButton = new JButton("Login");
        constraints.insets = new Insets(3,3,3,3);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        loginPanel.add(loginButton, constraints);
        
        signupButton = new JButton("Sign Up");
        constraints.insets = new Insets(3,3,3,3);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        loginPanel.add(signupButton, constraints);
        
        cancelButton = new JButton("Cancel");
        constraints.insets = new Insets(3,3,3,3);
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        loginPanel.add(cancelButton, constraints);
       
        //CANCEL BUTTON ACTION
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //dispose();
            	System.exit(0); //that's if we want to add this functionality
            }
        });//end cancelButton ActionListener
        
        //LOGIN BUTTON ACTION
        loginButton.addActionListener(new ActionListener() {
            @SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
                try {
                    DatabaseInterface auth = new DatabaseInterface();
                    if (auth.authenticate(getUsername(), getPassword())) {
                        JOptionPane.showMessageDialog(loginFrame,"Successfully Authenticated.");
                        Display displyUI = new Display();
                        dispose(); //not working
                    } else {
                        JOptionPane.showMessageDialog(loginFrame,"Incorrect Username and Password combination."
                                ,"Alert",JOptionPane.WARNING_MESSAGE);
                        // reset user name and password
                        usernameText.setText("");
                        passwordText.setText("");
                        //succeeded = false;
                    }//end else
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }//end actionPerformed
        });//end loginButton ActionListener
        
        //SIGN UP BUTTON ACTION
        signupButton.addActionListener(new ActionListener() {
            @SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
            	 //willupdate
            	SignUp signupFrame = new SignUp();
            }//end actionPerformed
        });//end loginButton ActionListener
        
        //Color is light gray by design
        loginPanel.setBorder(new LineBorder(Color.GRAY));
        
        //add the date time in here
        //add date
        LocalDateTime myDateObj = LocalDateTime.now();  
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy"); 
        //.ofPattern("E, MMM dd yyyy HH:mm:ss");  if we want a static time
        //if we want dynamic we make into a thread!
        String formattedDate = myDateObj.format(myFormatObj);   
        menuBar = new JMenuBar();
        dateTime = new JLabel(" "+ formattedDate);
        menuBar.add(dateTime); //Update with local time
        
        loginFrame = new JFrame();
        loginFrame.add(loginPanel);
        loginFrame.setTitle("Health Monitoring Login/Signup");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.add(loginPanel);
        loginFrame.setJMenuBar(menuBar);
        loginFrame.setSize(300, 300);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
        
	}//end Login()
	
    public String getUsername() {
        return usernameText.getText().trim();
    }
 
    public String getPassword() {
        return new String(((JPasswordField) passwordText).getPassword());
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
