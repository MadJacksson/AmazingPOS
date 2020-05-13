package se.kth.iv1350.amazingpos.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

/**
 * Takes care of the error messages for the user interface.
 */
public class ErrorMessageHandler {
    private static final ErrorMessageHandler ERROR_MESSAGE_HANDLER = new ErrorMessageHandler();
    private final String JUMP_LINE = "\n";
    private Date errorOccurred;

    private ErrorMessageHandler (){
    }

    /**
     * Gets the singleton instance of <code>ErrorMessageHandler</code>
     * @return
     */
    public static ErrorMessageHandler getErrorMessageHandler(){
        return ERROR_MESSAGE_HANDLER;
    }

    /**
     * Creates and gets the time and date
     * @return time and date in special format
     */
    private String getTimeAndDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }

    /**
     * Prints out a message to the user interface.
     * The printout will have the date of the error and the message.
     * @param message the message that will be printed out.
     */
    void showErrorMsg(String message){
        StringBuilder errorMsg = new StringBuilder();
        errorMsg.append("----NOTIFY-ERROR-TO-CASHIER----");
        errorMsg.append(JUMP_LINE);
        errorMsg.append(getTimeAndDate());
        errorMsg.append(JUMP_LINE);
        errorMsg.append("ERROR: " + message);
        errorMsg.append(JUMP_LINE);
        System.out.println(errorMsg.toString());
    }
}
