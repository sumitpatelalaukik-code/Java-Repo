public class PaymentProcessing {

    public static void checkout(Payment payment) {
        payment.processPayment(); 
        System.out.println();
    }

    public static void main(String[] args) {
    
        Payment p1 = new CashPayment(500.0, 1000.0);
        Payment p2 = new CardPayment(2499.0, "1234567890123456", "Sumit Patel");
        Payment p3 = new UPIPayment(150.0, "sumit@upi");

        checkout(p1);
        checkout(p2);
        checkout(p3);

        Payment[] orders = { p1, p2, p3 };
        System.out.println("=== Batch Processing All Payments ===");
        for (Payment p : orders) {
            p.processPayment();
            System.out.println();
        }
    }
}

class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public void processPayment() {
        System.out.println("Processing general payment of Rs. " + amount);
    }
}

class CashPayment extends Payment {
    private double cashGiven;

    public CashPayment(double amount, double cashGiven) {
        super(amount);
        this.cashGiven = cashGiven;
    }

    @Override
    public void processPayment() {
        System.out.println("--- Cash Payment ---");
        System.out.println("Bill Amount: Rs. " + amount);
        System.out.println("Cash Tendered: Rs. " + cashGiven);
        if (cashGiven >= amount) {
            double change = cashGiven - amount;
            System.out.println("Payment Successful. Return change: Rs. " + change);
        } else {
            System.out.println("Payment Failed: Insufficient cash provided!");
        }
    }
}

class CardPayment extends Payment {
    private String cardNumber;
    private String cardHolderName;

    public CardPayment(double amount, String cardNumber, String cardHolderName) {
        super(amount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void processPayment() {
        System.out.println("--- Card Payment ---");
        String maskedCard = "XXXX-XXXX-XXXX-" + cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Charging Rs. " + amount + " to Card: " + maskedCard);
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Payment Verified & Debited Successfully.");
    }
}

class UPIPayment extends Payment {
    private String upiId;

    public UPIPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    @Override
    public void processPayment() {
        System.out.println("--- UPI Payment ---");
        System.out.println("Requesting Rs. " + amount + " from UPI ID: " + upiId);
        System.out.println("UPI PIN verified. Transaction Successful!");
    }
}
