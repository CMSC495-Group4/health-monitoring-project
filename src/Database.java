
public class Database {

    public static boolean authenticate(String username, String password) {
    	boolean is_auth = false;
    	//user name and password for testing purposes 
    	//ultimately integrate with Todd's "public boolean authenticate" function
    	//and reading from the CSV
        if (username.equals("audrey") && password.equals("password")) {
        	is_auth = true;
            return is_auth;
        }
        return false;
    }
}