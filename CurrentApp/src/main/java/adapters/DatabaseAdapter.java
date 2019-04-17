package adapters;

import factories.UserFactory;
import models.UserModel;
import views.CreateAccountView;

import javax.imageio.ImageIO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DatabaseAdapter {

    public static UserModel verifyUser(String username, String password) {
        UserFactory uf = new UserFactory();
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
                    user = uf.getUser(split[6], split);
                    found = true;
                }
            }
        } catch(IOException a) {
            a.printStackTrace();
        }
        return user;
    }

    public static boolean userExists(String email) {
        boolean found = false;
        email = email.toLowerCase();
        try {
            Scanner sc = new Scanner(new File("./src/main/resources/Users.csv"));
            String line;
            String[] split;
            while (sc.hasNextLine() && !found) {
                line = sc.nextLine();
                split = line.split(",");
                if (email.equals(split[2].toLowerCase())) {
                    found = true;
                }
            }
        } catch(IOException a) {
            a.printStackTrace();
        }
        return found;
    }

    public static void writeUser(UserModel u) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./src/main/resources/Users.csv",
                    true));
            bw.write(u.getFullname() + "," + u.getUsername() + "," + u.getEmail() + "," +
                    u.getPassword() + "," + u.getCreditType() + "," +
                    u.getCreditCard() +  "\n");
            bw.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void SaveImage(UserModel u) {
        if(CreateAccountView.getPicture() != null) {
            u.setPictureLocation("./src/main/resources/" + u.getUsername() + ".png");
            File outfile = new File(u.getPictureLocation());
            try {
                ImageIO.write(CreateAccountView.getPicture(), "png", new File(outfile.getPath()));
            } catch(IOException | IllegalArgumentException e) {
                e.printStackTrace();
                //TODO add logger to catch this
            }
        }
    }
}
