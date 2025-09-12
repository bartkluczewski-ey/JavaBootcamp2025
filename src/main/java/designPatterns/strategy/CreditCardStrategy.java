package designPatterns.strategy;

import java.math.BigDecimal;

public class CreditCardStrategy implements PaymentStrategy {


    @Override
    public void pay(BigDecimal amount) {

        System.out.println("Paying using Credit Card: " + amount);

    }
}
