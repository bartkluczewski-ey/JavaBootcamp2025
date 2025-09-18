package designPatterns;

import designPatterns.builder.Burger;
import designPatterns.builder.Pizza;
import designPatterns.factory.MealFactory;
import designPatterns.strategy.CreditCardStrategy;
import designPatterns.strategy.PayPalStrategy;
import designPatterns.strategy.PaymentContext;

import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) {
        Burger burger = new Burger.Builder()
                .size("Big")
                .sauceType("Ketchup")
                .ingredients("Tomato")
                .ingredients("Cheese")
                .ingredients("100% beef")
                .ingredients("Salad")
                .build();

        System.out.println("Size: "+burger.getSize());
        System.out.println("Sauce type: "+burger.getSauceType());
        System.out.println("ingredients: "+burger.getIngredients());

        Pizza pizza = new Pizza.Builder()
                .size("Big")
                .extraCheese(true)
                .ingredients("Tomato")
                .ingredients("Cheese")
                .ingredients("100% beef")
                .ingredients("Salad")
                .build();

        System.out.println("Size: "+pizza.getSize());
        System.out.println("Pizza Extra cheese: "+pizza.getExtraCheese());
        System.out.println("ingredients: "+pizza.getIngredients());

        System.out.println("\n******************\n");

        MealFactory mealFactory = MealFactory.getInstance();
        PaymentContext paymentContext = new PaymentContext();

        Meal burgerFactory = mealFactory.createMeal("burger", "Big", "Ketchup", true, "Tomato", "Cheese", "100% beef", "Salad");
        System.out.println("Burger Size: " + ((Burger) burgerFactory).getSize());
        System.out.println("Burger Sauce type: " + ((Burger) burgerFactory).getSauceType());
        System.out.println("Burger ingredients: " + ((Burger) burgerFactory).getIngredients());

        paymentContext.setPaymentStrategy(new CreditCardStrategy());
        paymentContext.pay(new BigDecimal("29.99"));

        Meal pizzaFactory = mealFactory.createMeal("pizza", "Big", null, false, "Tomato", "Cheese", "100% beef", "Salad");
        System.out.println("Pizza Size: " + ((Pizza) pizzaFactory).getSize());
        System.out.println("Pizza Extra Cheese: "+ ((Pizza) pizzaFactory).getExtraCheese());
        System.out.println("Pizza ingredients: " + ((Pizza) pizzaFactory).getIngredients());

        paymentContext.setPaymentStrategy(new PayPalStrategy());
        paymentContext.pay(new BigDecimal("19.99"));

        System.out.println("\n****************** FACADE ******************\n");

        OrderFacade orderFacade = OrderFacade.getInstance();

        orderFacade.placeOrder("Burger", "Big", "BBQ", false, new CreditCardStrategy(), "Beef 100%", "Cheddar cheese", "Beckon");

        orderFacade.placeOrder("pizza","Big",null, true, new PayPalStrategy(), "Salami","Olives", "Cheese");





    }
}
