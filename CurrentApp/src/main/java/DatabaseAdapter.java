import javax.imageio.ImageIO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class DatabaseAdapter {

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
                        user = new UserModel(split[0], split[1], split[2], split[3], split[4], split[5]);
                        found = true;
                    }
                }
            } catch(IOException a) {
                a.printStackTrace();
            }
            return user;
        }

        public static void writeUser(UserModel u) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("./src/main/resources/Users.csv",
                        true));
                bw.write(u.getFullname() + "," + u.getUsername() + "," + u.getEmail() + "," + u.getPassword() +
                        "," + u.getCreditType() + "," + u.getCreditCard() +  "\n");
                bw.close();
            }catch(IOException e) {
                e.printStackTrace();
            }
        }

        public static void SaveImage(UserModel u) {
            u.setPictureLocation("./src/main/resources/" + u.getUsername() + ".png");
            File outfile = new File(u.getPictureLocation());
            try {
                ImageIO.write(CreateAccountView.getPicture(), "png", new File(outfile.getPath()));
            } catch(IOException ee) {
                ee.printStackTrace();
                //TODO add logger to catch this
            }
        }
    }
}
