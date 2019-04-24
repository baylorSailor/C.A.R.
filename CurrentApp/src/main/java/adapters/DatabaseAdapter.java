package adapters;

import controllers.UserController;
import factories.AdministratorFactory;
import factories.RepresentativeFactory;
import factories.UserFactory;
import main.CAR;
import models.UserModel;
import views.CreateAccountView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
            Scanner sc = new Scanner(new File("./src/main/resources/Users.csv"), "UTF-8");
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

                    //user = uf.getUser(split);
                    found = true;
                }
            }
        } catch(IOException a) {
            a.printStackTrace();
            log.log(Level.SEVERE,"User could not be verified in the Database");
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
            Scanner sc = new Scanner(new File("./src/main/resources/Users.csv"), "UTF-8");
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
            log.log(Level.SEVERE,"User could not be checked for existence in Database");
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
            log.log(Level.SEVERE,"User could not be written to Database");
        }
    }

    /**
     * Save the user's profile image
     * @param u the user
     */
    public static void saveImage(UserModel u) {
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
    public static BufferedImage loadImage() {
        BufferedImage picture = null;
        try {
            picture = ImageIO.read(new File("./src/main/resources/UserPics/" +
                    UserController.getUser().getUsername() + ".png"));
        } catch(IOException e) {
            try {
                picture = ImageIO.read(new File("./src/main/resources/sample.png"));
            } catch(IOException ee) {
                log.log(Level.SEVERE,"sample.png file couldn't be loaded");
            }

        }
        return picture;
    }

    /**
     * Loads all the makes in the vehicle list
     * @return the String array containing an all the makes
     */
    public static String[] loadallMakes() {
        List<String> arrayListMakes = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("./src/main/resources/vehiclesSmall.csv"), "UTF-8");
            String line;
            String[] split;
            line = sc.nextLine();
            arrayListMakes.add("-");
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                split = line.split(",");
                if (split.length == 15 && !arrayListMakes.contains(split[2])) {
                    arrayListMakes.add(split[2]);
                }
            }
        } catch(IOException a) {
            a.printStackTrace();
            log.log(Level.SEVERE,"Vehicle list could not be loaded");
        }

        String[] makes = new String[ arrayListMakes.size() ];
        arrayListMakes.toArray(makes);

        return makes;
    }

    /**
     * Loads all the models in the vehicle list with the selected make
     * @param selectedMake the make the user has selected
     * @return the String array containing an all the models within the provided make
     */
    public static String[] loadAllModels(String selectedMake) {
        List<String> arrayListModels = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("./src/main/resources/vehiclesSmall.csv"), "UTF-8");
            String line;
            String[] split;
            line = sc.nextLine();
            arrayListModels.add("-");
            while (sc.hasNextLine() && selectedMake != null) {
                line = sc.nextLine();
                split = line.split(",");
                if (split.length == 15 && !arrayListModels.contains(split[3]) && split[2].equals(selectedMake)) {
                    arrayListModels.add(split[3]);
                }
            }
        } catch(IOException a) {
            a.printStackTrace();
            log.log(Level.SEVERE,"Vehicle list could not be loaded");
        }

        String[] models = new String[ arrayListModels.size() ];
        arrayListModels.toArray(models);

        return models;
    }

    /**
     * Loads all the years in the vehicle list with the selected model
     * @param selectedModel the model the user has selected
     * @return the String array containing an all the years within the provided model
     */
    public static String[] loadAllYears(String selectedModel) {
        List<String> arrayListYears = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("./src/main/resources/vehiclesSmall.csv"), "UTF-8");
            String line;
            String[] split;
            line = sc.nextLine();
            arrayListYears.add("-");
            while (sc.hasNextLine() && selectedModel != null) {
                line = sc.nextLine();
                split = line.split(",");
                if (split.length == 15 && !arrayListYears.contains(split[5]) && split[3].equals(selectedModel)) {
                    arrayListYears.add(split[5]);
                }
            }
        } catch(IOException a) {
            a.printStackTrace();
            log.log(Level.SEVERE,"Vehicle list could not be loaded");
        }

        String[] years = new String[ arrayListYears.size() ];
        arrayListYears.toArray(years);

        return years;
    }

    /**
     * Loads all the vehicle classes in the vehicle list with the selected year
     * @param selectedYear the year the user has selected
     * @return the String array containing an all the types within the provided year
     */
    public static String[] loadAllTypes(String selectedYear) {
        List<String> arrayListTypes = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("./src/main/resources/vehiclesSmall.csv"));
            String line;
            String[] split;
            line = sc.nextLine();
            arrayListTypes.add("-");
            while (sc.hasNextLine() && selectedYear != null) {
                line = sc.nextLine();
                split = line.split(",");
                if (split.length == 15 && !arrayListTypes.contains(split[6]) && split[5].equals(selectedYear)) {
                    arrayListTypes.add(split[6]);
                }
            }
        } catch(IOException a) {
            a.printStackTrace();
            log.log(Level.SEVERE,"Vehicle list could not be loaded");
        }

        String[] types = new String[ arrayListTypes.size() ];
        arrayListTypes.toArray(types);

        return types;
    }
}
