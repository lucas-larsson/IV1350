package se.kth.iv1350.awesomepos.view;

import se.kth.iv1350.awesomepos.Integration.ConnectivityException;
import se.kth.iv1350.awesomepos.Integration.InvalidIdentifierException;
import se.kth.iv1350.awesomepos.controller.Controller;
import se.kth.iv1350.awesomepos.controller.OperationException;
import se.kth.iv1350.awesomepos.util.ConsoleLogger;
import se.kth.iv1350.awesomepos.util.FileLogger;
import se.kth.iv1350.awesomepos.util.TotalRevenueFileOutput;

/**
 * this class is a placeholder for the real view, it contains calls to all system operations in the controller.
 */
public class View {
    private final Controller ctrl;
    private final ErrorMessageHandler errorMsgHandler = ErrorMessageHandler.getErrorMessage();
    private final FileLogger fileLogger = new FileLogger("sale_log.txt");
    private final ConsoleLogger consoleLogger = ConsoleLogger.getConsoleLogger();
    /**
     * creates a new instance.
     * @param ctrl the controller object used in all controller calls.
     */

   public View (Controller ctrl){

       this.ctrl = ctrl;
       ctrl.addSaleInterface(new TotalRevenueView());
       ctrl.addSaleInterface(new TotalRevenueFileOutput());
   }
    /**
     * preform a fake sale by calling all the system operation in the controller.
     */
   public void runFakeExecution() throws ConnectivityException, InvalidIdentifierException, OperationException {
       startSale();
       //registerItem();
       registerItemException();
       concludeSale();
   }

    private void startSale() {
        ctrl.startSale();
        System.out.println("A new Sale has started.");
    }

    private void registerItem() throws InvalidIdentifierException, OperationException, ConnectivityException {
        System.out.println("Entering itemID: 123456, quantity: 1.");
        System.out.println(ctrl.registerItem("123456", 1));

        System.out.println("Entering itemID: 123457, quantity: 3.");
        System.out.println(ctrl.registerItem("123457", 3));

        System.out.println("Entering itemID: 123460, quantity: 5.");
        System.out.println(ctrl.registerItem("123460", 5));
    }

    private void concludeSale() {
        System.out.println("Cashier concludes sale.");
        TotalRevenueView totRv = new TotalRevenueView();
        totRv.newRevenue(ctrl.getTotal());
        try {
            double totalAmount = ctrl.getTotal();
            System.out.println("Total is: " + totalAmount + " $.");
            System.out.println("Customer pays: 2000.0 $");
            ctrl.concludeSale(2000);
        } catch (IllegalStateException exception) {
            errorMsgHandler.displayErrorMessage("Sale have not started yet");
        }

    }
    private void registerItemException () {
        try {
            System.out.println("Entering itemID: 123456 , quantity: 1.");
            System.out.println(ctrl.registerItem("123456", 1));

            System.out.println("Entering itemID: 123457, quantity: 3.");
            System.out.println(ctrl.registerItem("123457", 3));

            System.out.println("Entering itemID: 123495, quantity: 5.");
            System.out.println(ctrl.registerItem("123459", 5));
        } catch (Exception exception) {
            errorMsgHandler.displayErrorMessage(exception.getMessage());
            fileLogger.log(exception);
        }
    }
}
