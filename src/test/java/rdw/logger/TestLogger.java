package rdw.logger;

public class TestLogger extends Logger {
    
    private static TestLogger instance;

    private TestLogger() {
        super();
    }

    public static Logger getInstace() {
        if (instance == null) {
            instance = new TestLogger();
        }
        return instance;
    }

    public static void reset() {
        instance = null;
    }
}
