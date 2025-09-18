
package cleanCode;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class FileLoggingService implements LoggingService {
    private final String logFileName;

    public FileLoggingService(String logFileName) {
        this.logFileName = logFileName;
    }

    public void log(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(this.logFileName, true))) {
            LocalDateTime timestamp = LocalDateTime.now();
            writer.println(timestamp + ": " + message);
        } catch (IOException e) {
            System.err.println("Could not write to log file: " + e.getMessage());
        }

    }
}
