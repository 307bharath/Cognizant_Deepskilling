package ObserverPatternExample;

public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobilePro");
        Observer webApp = new WebApp("WebMaster");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        System.out.println("\nSetting price to 100.0");
        stockMarket.setPrice(100.0);

        System.out.println("Setting price to 105.5");
        stockMarket.setPrice(105.5);

        stockMarket.removeObserver(mobileApp);
        System.out.println("MobilePro observer removed.");

        stockMarket.registerObserver(new MobileApp("Mobileplus"));
        System.out.println("\nNew MobileApp observer named MobilePlus registered.");

        System.out.println("\nSetting price to 110.0");
        stockMarket.setPrice(110.0);

        
    }
}