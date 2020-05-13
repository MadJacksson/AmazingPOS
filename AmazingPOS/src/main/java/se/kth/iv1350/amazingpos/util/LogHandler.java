package se.kth.iv1350.amazingpos.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class that handles log
 */
public class LogHandler {
    private static final String LOG_FILE = "pos-log.txt";
    private PrintWriter logFile;
    private Date errorOccured;
    /**
     * Creator of log handler
     * @throws IOException
     */
    public LogHandler() throws IOException {
        logFile = new PrintWriter(new FileWriter(LOG_FILE), true);
    }

    /**
     * Creates the log file with exception
     * @param exception   Exception thrown
     */
    public void logException(Exception exception){
        StringBuilder logBuilder = new StringBuilder();
        logBuilder.append("Error log: \n");
        logBuilder.append(createTime());
        logBuilder.append(", Exception was thrown: ");
        logBuilder.append(exception.getMessage());
        logFile.println(logBuilder);
        exception.printStackTrace(logFile);
    }

    /**
     * Creates instance of time and date for log
     * @return   String with time and date
     */
    private String createTime (){
        errorOccured = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String errorTime = dateFormat.format(errorOccured);
        return errorTime;
    }
}
