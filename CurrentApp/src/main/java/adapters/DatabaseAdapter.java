package adapters;

import controllers.UserController;
import factories.AdministratorFactory;
import factories.RepresentativeFactory;
import factories.UserFactory;
import main.CAR;
import models.UserModel;
import views.CreateAccountView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Adapter for the database, interacts with the
 * back end data
 */
public class DatabaseAdapter {

    private static Logger log = Logger.getLogger(CAR.class.getName());

    /**
     * Verifies if a user exists
     * @param username the username
     * @param password the password
     * @return the user if it exists
     */
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
//                    if(split[6].equals("0")) {
//                        user = uf.getUser(split);
//                    } else if(split[6].equals("1")) {
//                        user = af.getUser(split);
//                    } else if(split[6].equals("2")) {
//                        user = rf.getUser(split);
//                    }

                    user = uf.getUser(split);
                    found = true;
                }
            }
        } catch(IOException a) {
            a.printStackTrace();
        }
        return user;
    }

    /**
     * Checks if user exists by email
     * @param email The user's email
     * @return true if user exists already, otherwise false
     */
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

    /**
     * Write the user to a CSV
     * @param u the user to write
     */
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

    /**
     * Save the user's profile image
     * @param u the user
     */
    public static void SaveImage(UserModel u) {
        if(CreateAccountView.getPicture() != null) {
            u.setPictureLocation("./src/main/resources/UserPics/" + u.getUsername() + ".png");
            File outfile = new File(u.getPictureLocation());
            try {
                ImageIO.write(CreateAccountView.getPicture(), "png", new File(outfile.getPath()));
            } catch(IOException | IllegalArgumentException e) {
                e.printStackTrace();
                log.log(Level.SEVERE,"User's selected image could not be saved");
            }
        }
    }

    /**
     * Loads the user's profile image
     * @return the BufferedImage containing the user's profile picture or sample image
     */
    public static BufferedImage LoadImage() {
        BufferedImage picture = null;
        try {
            picture = ImageIO.read(new File("./src/main/resources/UserPics/" +
                    UserController.getUser().getUsername() + ".png"));
        } catch(IOException e) {
            try {
                picture = ImageIO.read(new File("./src/main/resources/sample.png"));
            } catch(IOException ee) {
                log.log(Level.SEVERE,"Sample Profile Image couldn't be loaded");
            }

        }
        return picture;
    }
}
