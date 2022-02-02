package se.kth.iv1350.awesomepos.controller;

/**
 * Throws if the controller fails to register new product
 */
public class OperationException extends Exception {
    /**
     * Creates an instance of <code>ConnectivityException</code>.
     *
     * @param msg Information regarding the cause of the thrown exception.
     */
    public OperationException(String msg, OperationException cause) {
        super(msg);
    }
}
