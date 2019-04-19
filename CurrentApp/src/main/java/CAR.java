/**
 * The C.A.R app provides a simple, efficient, robust application
 * for the provision and acquisition of a wide range of rental cars,
 * promoting the reuse of vehicles.
 *
 * @author Andrew Case
 * @author Maggie Burton
 * @author Matthew Darby
 * @author Mark Du
 * @author Weston Straw
 * @version 1.0
 * @since   02-10-2019
 */

import controllers.UserController;

public class CAR {

    static UserController userController = new UserController();

    /**
     * Main method that runs the applications
     * @param args Array of arguments (command line parameters)
     */
    public static void main(String[] args) {

        userController.start();
    }
}
