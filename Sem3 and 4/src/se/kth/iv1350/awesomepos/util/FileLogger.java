package se.kth.iv1350.awesomepos.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements LogHandler {
    //    private static final FileLogger FILE_LOGGER = new FileLogger();
    //    private static final String NAME_OF_LOG_FILE = "sale_log.txt";
    private PrintWriter logFile;

    /**
     * Creates an instance of the FileLogger
     */
    public FileLogger(String fileName) {
        try {
            logFile = new PrintWriter(new FileWriter(fileName), true);
//            FILE_LOGGER = new FileLogger("sale")
        } catch (IOException exception) {
            System.out.println("Error while creating the logger.");
            exception.printStackTrace();
        }
    }

    /**
     * Gets the file logger
     *
     * @return the file logger
     */
    //    public static FileLogger getFileLogger() { return FILE_LOGGER; }

    /**
     * Prints and logs the specified string to a txt file.
     *
     * @param exception the string that will be logged
     */
    @Override
    public void log(Exception exception) {
        String logBuilder = "An Error Occured" +
                "\n at " + getDateAndTime() +
                "\n and the exception that was thrown was: " +
                exception.getMessage();
        logFile.println(logBuilder);
        exception.printStackTrace(logFile);
    }

    public void log(String str) {
        logFile.println(str);
    }
}
