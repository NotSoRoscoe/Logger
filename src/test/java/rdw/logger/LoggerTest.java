package rdw.logger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LoggerTest 
{
    @Test
    public void testLoggerDefaultsToERROR() 
    {
        String logMessage = "test Default to ERROR, should not print";
        Logger logger = Logger.getInstance();

        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act and Assert
        logger.log(LogLevel.WARN, logMessage);
        System.out.flush(); // Ensure the output is flushed
        String output = outputStream.toString();
        assertTrue(!output.contains(logMessage)); // Should not log WARN
        assertEquals(logger.getLogLevel(), LogLevel.ERROR);

        outputStream.reset(); // Clear the output stream for the next test

        logMessage = "test log an ERROR, This should print";
        logger.log(LogLevel.ERROR, logMessage);
        System.out.flush();
        output = outputStream.toString();
        assertTrue(output.contains(logMessage)); // Should log ERROR
    }

//    @Test
//    public void testLoggerPrintsInfo() 
//    {
//        boolean isPrinted = false;
//        Logger.setLogLevel(LogLevel.INFO);
//        
//        assertEquals(Logger.getLogLevel(), LogLevel.INFO);
//
//        isPrinted = Logger.print(LogLevel.ERROR, "ERROR should print");
//        assertTrue(isPrinted);
//
//        isPrinted = Logger.print(LogLevel.WARN, "WARN should print");
//        assertTrue(isPrinted);
//
//        isPrinted = Logger.print(LogLevel.DEBUG, "DEBUG should print");
//        assertTrue(isPrinted);
//
//        isPrinted = Logger.print(LogLevel.INFO, "INFO should print");
//        assertTrue(isPrinted);
//    }



}
