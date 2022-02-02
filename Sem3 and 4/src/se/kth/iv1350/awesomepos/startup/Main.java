package se.kth.iv1350.awesomepos.startup;

import se.kth.iv1350.awesomepos.Integration.DataBaseHandler;
import se.kth.iv1350.awesomepos.controller.Controller;
import se.kth.iv1350.awesomepos.view.View;
import se.kth.iv1350.awesomepos.controller.OperationException;
import se.kth.iv1350.awesomepos.Integration.InvalidIdentifierException;


/**
 * this class contains the main method that starts the entire application.
 */

public class Main {
    /**
     *
     * @param args no command line parameters are received by this method.
     */
    public static void main(String[] args) throws InvalidIdentifierException, OperationException {
        DataBaseHandler handler = new DataBaseHandler();
        Controller ctrl = new Controller(handler);
        View view = new View(ctrl);
        view.runFakeExecution();
    }
}