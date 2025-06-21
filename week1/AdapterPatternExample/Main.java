package AdapterPatternExample;

public class Main {
    public static void main(String[] args) {
        // Using RazorPayGateway directly
        RazorPayGateway razorPay = new RazorPayGateway();
        razorPay.makeRazorPayment(100.0);

        // Using PayPalGateway through the adapter
        PayPalGateway payPal = new PayPalGateway();
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        payPalAdapter.processPayment(200.0);
    }
}
