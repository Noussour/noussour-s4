package LoginPage;
import java.util.HashMap;

public class Model {
    private final HashMap<String, String> Users = new HashMap<>();

    public HashMap<String, String> getUsers() {
        return Users;
    }

    public void AddUser(String userName, String userPassword) {
        Users.put(userName, userPassword);
    }

    public boolean VerifyUser(String userName) {
       return Users.containsKey(userName);
    }

    public boolean VerifyPassword(String userName, String userPassword) {
        return Users.get(userName).equals(userPassword);
    }


}