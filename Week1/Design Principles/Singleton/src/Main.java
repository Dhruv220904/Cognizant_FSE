public class Main {

    public static void main(String[] args) {

        // Get Singleton object
        Logger logger1 = Logger.getInstance();

        // Again get Singleton object
        Logger logger2 = Logger.getInstance();

        // Again get Singleton object
        Logger logger3 = Logger.getInstance();

        logger1.log("Application Started");
        logger2.log("Database Connected");
        logger3.log("Application Closed");

        // Verify all references point to the same object
        System.out.println();

        System.out.println("logger1 == logger2 : " + (logger1 == logger2));
        System.out.println("logger2 == logger3 : " + (logger2 == logger3));
        System.out.println("logger1 == logger3 : " + (logger1 == logger3));
    }
}