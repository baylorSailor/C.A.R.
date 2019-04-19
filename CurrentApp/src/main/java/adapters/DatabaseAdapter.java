package adapters;

import factories.AdministratorFactory;
import factories.RepresentativeFactory;
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
        UserFactory uf = UserFactory.UserFactory();
        AdministratorFactory af = AdministratorFactory.AdministratorFactory();
        RepresentativeFactory rf = RepresentativeFactory.RepresentativeFactory();
        boolean found = false;
        UserModel user = null;
        try {
            Scanner sc = new Scanner(new File("./src/main/resources/Users.csv"));
            String line;
            String[] split;
            while (sc.hasNextLine() && !found) {
                line = sc.nextLine();
                split = line.split(",");

                //If username and password match, return that user
                if (username.equals(split[1]) && password.equals(split[3])) {
                    if(split[6].equals("0")) {
                        user = uf.getUser(split);
                    } else if(split[6].equals("1")) {
                        user = af.getUser(split);
                    } else if(split[6].equals("2")) {
                        user = rf.getUser(split);
                    }
                    found = true;
                }
            }
        } catch(IOException a) {
            a.printStackTrace();
        }
        return user;
    }

    //Checks if user exists by email
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

    //Write the user to the CSV file
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
