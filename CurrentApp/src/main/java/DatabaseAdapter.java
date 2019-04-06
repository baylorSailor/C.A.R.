import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DatabaseAdapter {

    public static class Users {

        public static UserModel verifyUser(String username, String password) {
            boolean found = false;
            UserModel user = null;
            try {
                Scanner sc = new Scanner(new File("./src/main/resources/Users.csv"));
                String line;
                String[] split;
                while (sc.hasNextLine() && !found) {
                    line = sc.nextLine();
                    split = line.split(",");
                    if (username.equals(split[1]) && password.equals(split[3])) {
                        user = new UserModel(split[0], split[1], split[2], split[4], split[5]);
                        found = true;
                    }
                }
            } catch(IOException a) {
                a.printStackTrace();
            }
            return user;
        }
    }
}
