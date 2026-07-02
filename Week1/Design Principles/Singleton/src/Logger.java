public class Logger {

    // Step 1: Create a static variable to hold the single instance
    private static Logger instance;

    // Step 2: Make constructor private
    // This prevents creating objects using 'new'
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Step 3: Provide a public static method to access the instance
    public static Logger getInstance() {

        // Create object only once
        if (instance == null) {
            instance = new Logger();
        }

        // Return the same object every time
        return instance;
    }

    // Logging method
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}