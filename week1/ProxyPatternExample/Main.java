package ProxyPatternExample;
public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.png");
        Image image2 = new ProxyImage("photo2.png");

        // Image will be loaded from remote server only on first display
        image1.display(); // Loads and displays
        image1.display(); // Only displays (cached)

        image2.display(); // Loads and displays
    }
}