package designPatterns.strategy;

import java.math.BigDecimal;

public interface PaymentStrategy {

    void pay(BigDecimal amount);

}
