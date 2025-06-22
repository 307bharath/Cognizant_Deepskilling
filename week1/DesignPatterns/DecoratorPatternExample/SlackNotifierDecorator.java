package DecoratorPatternExample;

public class SlackNotifierDecorator implements Notifier {
    private Notifier notifier;

    public SlackNotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
        System.out.println("Sending Slack notification: " + message);
    }
}