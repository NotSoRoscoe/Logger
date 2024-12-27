package rdw.logger;

public class Logger
{
    private static Logger instance;
    private static LogLevel logLevel = LogLevel.ERROR;

    private Logger() {
    }
    
    public static Logger getLogger() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    /**
     * Prints the log message based on the log level
     * and returns true if it was at a printable level
     * otherwise it reurns false.
     * @param level The LogLevel enum value of the log message
     * @param message The String Log message
     * @return True if the level was able to print, false otherwise.
    */
    public static boolean print(LogLevel level, String s) { 
        if (withinLevelThreshold(level)) {
            System.out.println(s);
            return true;
        }
        return false;
    }

    public static void setLogLevel(LogLevel level) {
        logLevel = level;
    }

    public static LogLevel getLogLevel() {
        return logLevel;
    }

    private static boolean withinLevelThreshold(LogLevel level) {
        return logLevel.getSeverity() <= level.getSeverity();
    }

    
}
