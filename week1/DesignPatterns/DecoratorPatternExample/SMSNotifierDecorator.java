package DecoratorPatternExample;

public class SMSNotifierDecorator implements Notifier {
    private Notifier notifier;

    public SMSNotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
        System.out.println("Sending SMS: " + message);
    }
}