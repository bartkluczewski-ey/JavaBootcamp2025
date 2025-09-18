package designPatterns.strategy;

import java.math.BigDecimal;

public class PayPalStrategy implements PaymentStrategy {


    @Override
    public void pay(BigDecimal amount) {

        System.out.println("Paying using PayPal: " + amount);

    }
}
