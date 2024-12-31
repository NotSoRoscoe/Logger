package rdw.logger;

public class Logger
{
    private static Logger instance;
    private LogLevel logLevel = LogLevel.ERROR;

    private Logger() {
    }
    
    public static Logger getInstance() {
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
    public void log(LogLevel level, String s) { 
        if (withinLevelThreshold(level)) {
            System.out.println("[" + level.toString() + "] " + s);
        }
    }

    public void setLogLevel(LogLevel level) {
        logLevel = level;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    private boolean withinLevelThreshold(LogLevel level) {
        return logLevel.ordinal() <= level.ordinal();
    }

    
}
