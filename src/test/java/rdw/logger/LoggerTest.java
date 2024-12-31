package rdw.logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoggerTest 
{
    @BeforeEach
    public void reset() {
        TestLogger.reset();
    }

    @Test
    public void testLoggerDefaultsToERROR() 
    {
        String logMessage = "test Default to ERROR, should not print";
        TestLogger logger = TestLogger.getInstance();

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

    @Test
    public void testLoggerPrintsWarn() 
    {
        String logMessage = "test Warn, should print WARN and ERROR";
        TestLogger logger = TestLogger.getInstance();
        logger.setLogLevel(LogLevel.WARN);

        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act and Assert
        logger.log(LogLevel.DEBUG, logMessage);
        System.out.flush(); // Ensure the output is flushed
        String output = outputStream.toString();
        assertTrue(!output.contains(logMessage)); // Should not log WARN
        assertEquals(logger.getLogLevel(), LogLevel.WARN);

        outputStream.reset(); // Clear the output stream for the next test

        logMessage = "test log an WARN, This should print";
        logger.log(LogLevel.WARN, logMessage);
        System.out.flush();
        output = outputStream.toString();
        assertTrue(output.contains(logMessage)); // Should log ERROR

        outputStream.reset(); // Clear the output stream for the next test

        logMessage = "test log an ERROR, This should print";
        logger.log(LogLevel.ERROR, logMessage);
        System.out.flush();
        output = outputStream.toString();
        assertTrue(output.contains(logMessage)); // Should log ERROR
    }

}
