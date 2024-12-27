package rdw.logger;

public enum LogLevel
{
    INFO(0),
    DEBUG(1),
    WARN(2),
    ERROR(3);

    private final int severity;

    LogLevel(int severity) {
        this.severity = severity;
    }

    public int getSeverity() {
	    return severity;
    }
}
