package main;

import controllers.UserController;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CAR {

    public static Logger logger = java.util.logging.Logger.getLogger("CARLog");
    static {
        try {
            InputStream configFile = CAR.class.getClassLoader().getResourceAsStream("logger.properties");
            LogManager.getLogManager().readConfiguration(configFile);
            configFile.close();
        } catch (
                IOException ex) {
            System.out.println("WARNING: Could not open configuration file");
            System.out.println("WARNING: Logging not configured (console output only)");
        }
        logger.info("Starting the application...");
    }

    static UserController userController = new UserController();

    public static void main(String[] args) {
        userController.start();
    }
}
