package com.java17.trickyExamples;

public class RecordsWithSealed {

    // 1. Sealed interface defines a strictly controlled hierarchy
    sealed interface PaymentMethod permits Card, Crypto, Cash {}

    // 2. Records for concise data carriers
    record Card(String number, String expiry, CardType type) implements PaymentMethod {}
    record Crypto(String walletAddress, String currency) implements PaymentMethod {}
    record Cash(double amount) implements PaymentMethod {}

    enum CardType { VISA, MASTER_CARD }

    public static String processPayment(PaymentMethod method) {
        // 3. Exhaustive switch (no default needed) 
        // Note: Using Java 17 Preview syntax (&&)
        return switch (method) {
            case Cash c && c.amount() > 10000 -> 
                "Flagging large cash transaction: $" + c.amount();
            
            case Cash c -> 
                "Processing cash: $" + c.amount();

            case Card c && c.type() == CardType.VISA -> 
                "Processing Visa card ending in: " + c.number().substring(12);

            case Card c -> 
                "Processing generic card";

            case Crypto crypt && crypt.currency().equals("BTC") -> 
                "Processing Bitcoin to: " + crypt.walletAddress();
            
            case Crypto crypt -> 
                "Processing altcoin: " + crypt.currency();
                
            // case null is handled here to avoid NPE
            case null -> "Error: Payment method cannot be null";
        };
    }

    public static void main(String[] args) {
        PaymentMethod myPay = new Card("1234567812345678", "12/25", CardType.VISA);
        System.out.println(processPayment(myPay));
        
        PaymentMethod highCash = new Cash(15000.00);
        System.out.println(processPayment(highCash));
    }
}