package se.kth.iv1350.awesomepos.util;

public class ConsoleLogger implements LogHandler {
    private static final ConsoleLogger CONSOLE_LOGGER = new ConsoleLogger();

    /**
     * Creates an instance of the FileLogger
     */
    public ConsoleLogger() {
    }

    /**
     * Gets the console logger
     *
     * @return the console logger
     */
    public static ConsoleLogger getConsoleLogger() {
        return CONSOLE_LOGGER;
    }

    /**
     * Prints and logs the specified string to the console
     *
     * @param exception the string that will be output
     */
    @Override
    public void log(Exception exception) {
        String logBuilder = "An Error Occured" +
                "\n at " + getDateAndTime() +
                "\n and the exception that was thrown was: " +
                exception.getMessage();
        System.out.println(logBuilder);
        exception.printStackTrace(System.out);
    }

}
