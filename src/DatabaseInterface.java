//package chart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Database Interface Class
 * This class connects to a CSV file that stores user data and has several methods to access and modify
 * the data. The class validates username and password combinations. This class allows for checking if a user exists.
 *  
 * @author Todd Weber
 *
 */
public class DatabaseInterface {
	
	private BufferedReader reader;	
	private BufferedWriter writer;
	private File input_file;
	private File temp_file;
	
	/**
	 * Constructor
	 * 
	 * Checks if file exists and creates it if it does not.
	 * @throws IOException 
	 */
	public DatabaseInterface() throws IOException {
		
		input_file = new File("data.csv");
		temp_file = new File("tmp.csv");		
		
		//creates file if it does not exist
		if(!input_file.isFile() && !input_file.exists())
			input_file.createNewFile();	
		
	}
	/**
	 * Returns a boolean value depending if the username and password match the stored values.
	 * 
	 * @param username		a string username.
	 * @param password		a string password.
	 * @return				true if username and password match stored values, false otherwise.
	 * @throws IOException	
	 */
	public boolean authenticate(String username, String password) throws IOException {
		
		reader = new BufferedReader(new FileReader(input_file));
		boolean is_auth = false;	
		String next_record;
		
		//loops through file looking for username 
		while ((next_record = reader.readLine()) != null) {
		    String[] data = next_record.split(",");
		    if (data[0].equals(username) && data[1].equals(password)){
		            is_auth = true;
		            break;
		    }
		}
		reader.close();
		return is_auth;
	}

	/**
	 * Adds a user to the CSV file. Appends the user to the end of the file. 
	 * 
	 * @param username		a string username.
	 * @param password		a string password.
	 * @param bios			a string array of biometric data.
	 * @throws IOException
	 */
	public void add_user(String username, String password, String[] bios) throws IOException {

		writer = new BufferedWriter(new FileWriter(input_file,true));		
		writer.append(username+","+password+","+String.join(",", bios)+"\n");
		writer.flush();
		writer.close();
	}

	/**
	 * Checks the CSV file to determine if a user exists.
	 * 
	 * @param username		a string username.
	 * @return				true if user exists, false otherwise.
	 * @throws IOException
	 */
	public boolean user_exists(String username) throws IOException {
		
		reader = new BufferedReader(new FileReader(input_file));
		boolean exists = false;		
		String next_record;
		
		//loops through file looking for username
		while ((next_record = reader.readLine()) != null) {
		    String[] data = next_record.split(",");
		    if (data[0].equals(username)){ 
		            exists = true;
		            break;
		    }
		}
		reader.close();		
		return exists;
	}
	
	/**
	 * Updates the stored biometric data of the specified user. Rewrites the CSV into a new 
	 * file with the users data being rewritten.
	 * 
	 * @param username		a string username.
	 * @param bios			a string array with biometric data.
	 * @throws IOException
	 */
	public void update_bios(String username, String[] bios) throws IOException {
		
		reader = new BufferedReader(new FileReader(input_file));
		writer = new BufferedWriter(new FileWriter(temp_file));	
		String next_record;
		
		//loops through file rewriting to temp file
		while ((next_record = reader.readLine()) != null) {
			String[] data = next_record.split(",");
		    if (data[0].equals(username)){
		    	//rewrite bio data
		    	for(int i = 0; i <bios.length; i++)
	            	data[i+2] = bios[i];
		    	
		    	writer.append(String.join(",",data));
		    	writer.append("\n");
			}
		    else {
		    	writer.append(next_record);
		    	writer.append("\n");
		    }
			
		}//end while		
		writer.flush();
		writer.close();
		reader.close();
		
		//delete main file and renames temp file to replace
		input_file.delete();
		temp_file.renameTo(input_file);
		 
	}
	
	/**
	 * Deletes a user from the CSV. Rewrites the CSV without the specified user.
	 * 
	 * @param username		a string username.
	 * @throws IOException
	 */
	public void delete_user(String username) throws IOException {
		
		reader = new BufferedReader(new FileReader(input_file));
		writer = new BufferedWriter(new FileWriter(temp_file));	
		String next_record;
		
		//loops through file rewriting to temp file
		while ((next_record = reader.readLine()) != null) {
			String[] data = next_record.split(",");
		    //does not rewrite deleted user
			if (!data[0].equals(username)){
		    	writer.append(next_record);
		    	writer.append("\n");//do nothing
			}			
		}//end while
		writer.flush();
		writer.close();
		reader.close();
		
		//delete main file and renames temp file to replace
		input_file.delete();
		temp_file.renameTo(input_file);
	}
	
	/**
	 * Returns a string array of biometric data for the user. 
	 * 
	 * @param username	a string username.
	 * @return			a string array.
	 * @throws IOException
	 */
	public String[] get_bios(String username) throws IOException {
		
		reader = new BufferedReader(new FileReader(input_file));
		String[] bios = new String[20];		
		String next_record;
		
		//loops through file for user data
		while ((next_record = reader.readLine()) != null) {			
		    String[] data = next_record.split(",");
		    if (data[0].equals(username)){
		    	for(int i = 2; i <bios.length; i++)
		            	bios[i] = data[i];//do not want username and password
		    }
		}
		reader.close();		
		return bios;
	}
}
