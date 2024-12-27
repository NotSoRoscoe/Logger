package rdw.logger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTest 
{

    @Test
    public void testLoggerDefaultsToERROR()
    {
        boolean isPrinted = true;
        isPrinted = Logger.print(LogLevel.INFO, "test Default to ERROR, should not print");
        
        assertTrue(!isPrinted);
        assertEquals(Logger.getLogLevel(), LogLevel.ERROR);
    }

    @Test
    public void testLoggerPrintsInfo() 
    {
        boolean isPrinted = false;
        Logger.setLogLevel(LogLevel.INFO);
        
        assertEquals(Logger.getLogLevel(), LogLevel.INFO);

        isPrinted = Logger.print(LogLevel.ERROR, "ERROR should print");
        assertTrue(isPrinted);

        isPrinted = Logger.print(LogLevel.WARN, "WARN should print");
        assertTrue(isPrinted);

        isPrinted = Logger.print(LogLevel.DEBUG, "DEBUG should print");
        assertTrue(isPrinted);

        isPrinted = Logger.print(LogLevel.INFO, "INFO should print");
        assertTrue(isPrinted);
    }

    @Test
    public void testLoggerPrintsDebug() 
    {
        boolean isPrinted = false;
        Logger.setLogLevel(LogLevel.DEBUG);
        
        assertEquals(Logger.getLogLevel(), LogLevel.DEBUG);

        isPrinted = Logger.print(LogLevel.ERROR, "ERROR should print");
        assertTrue(isPrinted);

        isPrinted = Logger.print(LogLevel.WARN, "WARN should print");
        assertTrue(isPrinted);

        isPrinted = Logger.print(LogLevel.DEBUG, "DEBUG should print");
        assertTrue(isPrinted);

        isPrinted = Logger.print(LogLevel.INFO, "INFO should not print");
        assertTrue(!isPrinted);
    }

    @Test
    public void testLoggerPrintsWarn() 
    {
        boolean isPrinted = false;
        Logger.setLogLevel(LogLevel.WARN);
        
        assertEquals(Logger.getLogLevel(), LogLevel.WARN);

        isPrinted = Logger.print(LogLevel.ERROR, "ERROR should print");
        assertTrue(isPrinted);

        isPrinted = Logger.print(LogLevel.WARN, "WARN should print");
        assertTrue(isPrinted);

        isPrinted = Logger.print(LogLevel.DEBUG, "DEBUG should not print");
        assertTrue(!isPrinted);

        isPrinted = Logger.print(LogLevel.INFO, "INFO should not print");
        assertTrue(!isPrinted);
    }

    @Test
    public void testLoggerPrintsError() 
    {
        boolean isPrinted = false;
        Logger.setLogLevel(LogLevel.ERROR);
        
        assertEquals(Logger.getLogLevel(), LogLevel.ERROR);

        isPrinted = Logger.print(LogLevel.ERROR, "ERROR should print");
        assertTrue(isPrinted);

        isPrinted = Logger.print(LogLevel.WARN, "WARN should not print");
        assertTrue(!isPrinted);

        isPrinted = Logger.print(LogLevel.DEBUG, "DEBUG should not print");
        assertTrue(!isPrinted);

        isPrinted = Logger.print(LogLevel.INFO, "INFO should not print");
        assertTrue(!isPrinted);
    }
}
