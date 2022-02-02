package se.kth.iv1350.awesomepos.view;

import java.time.LocalDateTime;

public class ErrorMessageHandler {
        private static final ErrorMessageHandler ERROR_MESSAGE = new ErrorMessageHandler();
        LocalDateTime timeRightNow = LocalDateTime.now();

        public ErrorMessageHandler() {
        }

        /**
         * @return the error message
         */
        public static ErrorMessageHandler getErrorMessage() {
            return ERROR_MESSAGE;
        }

        /**
         * @return the date and time of today
         */
        public String getDateAndTime() {
            return timeRightNow.toString();
        }

        /**
         * Displays the specified error message.
         *
         * @param msg The error message to display.
         */
        void displayErrorMessage(String msg) {
            String Error = getDateAndTime() +
                    "\n" +
                    " ERROR: " +
                    "\n" +
                    msg +
                    "\n";
            System.out.println(Error);
        }
}

