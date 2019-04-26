package adapters;

import controllers.UserController;
import factories.AbstractUserFactory;
import factories.AdministratorFactory;
import factories.RepresentativeFactory;
import factories.UserFactory;
import main.CAR;
import models.CarModel;
import models.HistoryModel;
import models.UserModel;
import views.CreateAccountView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
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
    public static CarModel[] CarList;

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
     * Update the user in CSV
     * @param oldUser the old user
     * @param newUser the new user to be written
     */
    public static void updateUser(UserModel oldUser, UserModel newUser) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("./src/main/resources/Users.csv")));
            String line = "", originalLine = "";
            while((line = reader.readLine()) != null) {
                originalLine += line + '\n';
            }
            reader.close();

            String newtext = originalLine.replaceAll(oldUser.getFullname() + "," + oldUser.getUsername() + "(.*)", newUser.toString());
            FileWriter writer = new FileWriter("./src/main/resources/Users.csv");
            writer.write(newtext);
            writer.close();

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
     * Save the user's new password
     * @param newPassword the user's new password
     */
    public static void updatePassword(String newPassword) {
        UserController.getUser().setPassword(newPassword);
        updateUser(UserController.getUser(),UserController.getUser());
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
     * Function for reading history CSV
     */
    public static ArrayList<HistoryModel> readHistory(){
        ArrayList<HistoryModel> historyModelArrayList = new ArrayList<>();
        try {
            String username = UserController.getUser().getUsername();
            Scanner input = new Scanner(new File("./src/main/resources/history.csv"), "UTF-8");
            input.nextLine();
            String line;

            while (input.hasNextLine()) {
                line = input.nextLine();
                String[] data = line.split(",");
                if(data[0].equalsIgnoreCase(username)) {
                    historyModelArrayList.add(new HistoryModel(data));
                }
            }

        }catch(Exception e){
            e.printStackTrace();
            log.log(Level.SEVERE,"history.csv could not be loaded");
        }
        return historyModelArrayList;
    }

    /**
     * Loads all the cars in the CSV into a list
     * @return the CarModel array containing an all the cars
     */
    public static CarModel[] loadAllCars() {
        List<CarModel> arrayListCars = new ArrayList<>();

        try{
            Scanner sc = new Scanner(new File("./src/main/resources/vehiclesSmall.csv"), "UTF-8");
            String line;
            String[] split;
            line = sc.nextLine();
            while(sc.hasNextLine()) {
                line = sc.nextLine();
                split = line.split(",");
                if(split.length == 15) {
                    arrayListCars.add(new CarModel(split));
                }
            }
        } catch(IOException a) {
            a.printStackTrace();
            log.log(Level.SEVERE, "Vehicle list could not be loaded");
        }

        CarModel[] modelArray = new CarModel[ arrayListCars.size() ];
        arrayListCars.toArray(modelArray);
        CarList = modelArray;

        return CarList;
    }

    /**
     * Loads all the makes in the vehicle list
     * @return the String array containing an all the makes
     */
    public static String[] loadAllMakes() {
        List<String> arrayListMakes = new ArrayList<>();
        arrayListMakes.add("-");
        for(CarModel i : CarList) {
            if(!arrayListMakes.contains(i.getMake())) {
                arrayListMakes.add(i.getMake());
            }
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
        arrayListModels.add("-");
        for(CarModel i : CarList) {
            if(i.getMake().equals(selectedMake) && !arrayListModels.contains(i.getModel())) {
                arrayListModels.add(i.getModel());
            }
        }

        String[] models = new String[ arrayListModels.size() ];
        arrayListModels.toArray(models);

        return models;
    }

    /**
     * Loads all the years in the vehicle list with the selected model
     * @param selectedMake the make the user has selected
     * @param selectedModel the model the user has selected
     * @return the String array containing an all the years within the provided model
     */
    public static String[] loadAllYears(String selectedMake, String selectedModel) {
        List<String> arrayListYears = new ArrayList<>();
        arrayListYears.add("-");
        for(CarModel i : CarList) {
            if(i.getMake().equals(selectedMake) && i.getModel().equals(selectedModel)
                    && !arrayListYears.contains(i.getYear().toString())) {
                arrayListYears.add(i.getYear().toString());
            }
        }

        String[] models = new String[ arrayListYears.size() ];
        arrayListYears.toArray(models);

        return models;
    }

    /**
     * Loads all the vehicle classes in the vehicle list with the selected year
     * @param selectedMake the make the user has selected
     * @param selectedModel the model the user has selected
     * @param selectedYear the year the user has selected
     * @return the String array containing an all the types within the provided year and model
     */
    public static String[] loadAllTypes(String selectedMake, String selectedModel, String selectedYear) {
        List<String> arrayListTypes = new ArrayList<>();
        arrayListTypes.add("-");
        for(CarModel i : CarList) {
            if(i.getMake().equals(selectedMake) && i.getModel().equals(selectedModel)
                    && i.getYear().toString().equals(selectedYear) && !arrayListTypes.contains(i.getType())) {
                arrayListTypes.add(i.getType());
            }
        }

        String[] types = new String[ arrayListTypes.size() ];
        arrayListTypes.toArray(types);

        return types;
    }

    /**
     * Loads all the vehicle classes in the vehicle list with the selected transmission
     * @param selectedMake the make the user has selected
     * @param selectedModel the model the user has selected
     * @param selectedYear the year the user has selected
     * @param selectedType the type the user has selected
     * @return the String array containing an all the types within the provided year, model, and type
     */
    public static String[] loadAllTransmissions(String selectedMake, String selectedModel,
                                                String selectedYear, String selectedType) {
        List<String> arrayListTransmissions = new ArrayList<>();
        arrayListTransmissions.add("-");
        for(CarModel i : CarList) {
            if(i.getMake().equals(selectedMake) && i.getModel().equals(selectedModel)
                    && i.getYear().toString().equals(selectedYear)
                    && i.getType().equals(selectedType)
                    && !arrayListTransmissions.contains(i.getTransmission())) {
                arrayListTransmissions.add(i.getTransmission());
            }
        }

        String[] trans = new String[ arrayListTransmissions.size() ];
        arrayListTransmissions.toArray(trans);

        return trans;
    }

    /**
     * Loads all the vehicle classes in the vehicle list with the selected interior color
     * @param selectedMake the make the user has selected
     * @param selectedModel the model the user has selected
     * @param selectedYear the year the user has selected
     * @param selectedType the type the user has selected
     * @param selectedTrans the transmission the user has selected
     * @return the String array containing an all the cars within the provided year, model, type, and transmission
     */
    public static String[] loadAllInteriorColor(String selectedMake, String selectedModel,
                                                String selectedYear, String selectedType,
                                                String selectedTrans) {
        List<String> arrayListInteriorColor = new ArrayList<>();
        arrayListInteriorColor.add("-");
        for(CarModel i : CarList) {
            if(i.getMake().equals(selectedMake) && i.getModel().equals(selectedModel)
                    && i.getYear().toString().equals(selectedYear)
                    && i.getType().equals(selectedType)
                    && i.getTransmission().equals(selectedTrans)
                    && !arrayListInteriorColor.contains(i.getInterior())) {
                arrayListInteriorColor.add(i.getInterior());
            }
        }

        String[] trans = new String[ arrayListInteriorColor.size() ];
        arrayListInteriorColor.toArray(trans);

        return trans;
    }

    /**
     * Loads all the vehicle classes in the vehicle list with the selected exterior color
     * @param selectedMake the make the user has selected
     * @param selectedModel the model the user has selected
     * @param selectedYear the year the user has selected
     * @param selectedType the type the user has selected
     * @param selectedTrans the transmission the user has selected
     * @param selectedInteriorColor the interior color the user has selected
     * @return the String array containing an all the cars within the provided year, model, type,
     * transmission, and interior color
     */
    public static String[] loadAllExteriorColor(String selectedMake, String selectedModel,
                                                String selectedYear, String selectedType,
                                                String selectedTrans, String selectedInteriorColor) {
        List<String> arrayListExteriorColor = new ArrayList<>();
        arrayListExteriorColor.add("-");
        for(CarModel i : CarList) {
            if(i.getMake().equals(selectedMake) && i.getModel().equals(selectedModel)
                    && i.getYear().toString().equals(selectedYear)
                    && i.getType().equals(selectedType)
                    && i.getTransmission().equals(selectedTrans)
                    && i.getInterior().equals(selectedInteriorColor)
                    && !arrayListExteriorColor.contains(i.getExterior())) {
                arrayListExteriorColor.add(i.getExterior());
            }
        }

        String[] trans = new String[ arrayListExteriorColor.size() ];
        arrayListExteriorColor.toArray(trans);

        return trans;
    }
}
