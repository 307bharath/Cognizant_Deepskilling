package SingletonPatternExample;

// Main.java
public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();  

        logger1.log("Message from logger1");
        logger2.log("Message from logger2");
        System.out.println("Are both logger instances the same? " + (logger1 == logger2));
    }
}