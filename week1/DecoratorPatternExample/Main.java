package DecoratorPatternExample;

public class Main {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        Notifier smsNotifier =  new SMSNotifierDecorator(notifier);
        Notifier slackAndSmsNotifier = new SlackNotifierDecorator(smsNotifier);

        System.out.println("Email only:");
        notifier.send("Hello!");

        System.out.println("\nEmail + SMS:");
        smsNotifier.send("Hello!");

        System.out.println("\nEmail + SMS + Slack:");
        slackAndSmsNotifier.send("Hello!");
    }
}