package behavioural;

// Abstract handler
abstract class Logger {
    protected int level;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message);
}

// Concrete handlers
class InfoLogger extends Logger {
    public InfoLogger() {
        this.level = 1;
    }

    @Override
    protected void write(String message) {
        System.out.println("Info: " + message);
    }
}

class ErrorLogger extends Logger {
    public ErrorLogger() {
        this.level = 2;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error: " + message);
    }
}

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        Logger infoLogger = new InfoLogger();
        Logger errorLogger = new ErrorLogger();
        infoLogger.setNextLogger(errorLogger);

        // Logging messages with different severity levels
        infoLogger.logMessage(1, "This is an informational message.");
        infoLogger.logMessage(2, "This is an error message.");
    }
}
