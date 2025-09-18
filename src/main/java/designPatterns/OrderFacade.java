package designPatterns;

import designPatterns.factory.MealFactory;
import designPatterns.strategy.PaymentContext;
import designPatterns.strategy.PaymentStrategy;

import java.math.BigDecimal;

public class OrderFacade {

    private static OrderFacade instance;

    private final MealFactory mealFactory;

    private final PaymentContext paymentContext;

    private OrderFacade(){
        this.mealFactory = MealFactory.getInstance();
        this.paymentContext = new PaymentContext();
    }

    public static OrderFacade getInstance(){
        if(instance==null) instance = new OrderFacade();
        return instance;
    }

    public void placeOrder(String mealType, String size, String sauceType, boolean extraCheese, PaymentStrategy paymentStrategy, String... ingredients){
        System.out.println("Preparing new order...");

        Meal meal = mealFactory.createMeal(mealType,size,sauceType,extraCheese,ingredients);
        System.out.println("Created meal: "+mealType);

        meal.prepare();

        BigDecimal price = meal.getPrice();

        paymentContext.setPaymentStrategy(paymentStrategy);
        paymentContext.pay(price);
        System.out.println("Order created successfully");


    }

}
