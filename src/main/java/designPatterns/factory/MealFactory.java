package designPatterns.factory;

import designPatterns.Meal;
import designPatterns.builder.Burger;
import designPatterns.builder.Pizza;

public class MealFactory {

    private static MealFactory instance;

    private MealFactory(){}

    public static MealFactory getInstance(){
        if(instance == null){
            instance = new MealFactory();
        }
        return instance;
    }

    public Meal createMeal(String mealType, String size, String sauceType, boolean extraCheese, String... ingredients){
        switch(mealType.toLowerCase()){
            case "burger" -> {
                return createBurger(size, sauceType, ingredients);
            }
            case "pizza"->{
                return createPizza(size, extraCheese, ingredients);
            }
            default->{
                throw new IllegalArgumentException("Unknown meal type");
            }
        }
    }

    private static Meal createBurger(String size, String sauceType, String[] ingredients) {
        Burger.Builder builder = new Burger.Builder()
                .size(size)
                .sauceType(sauceType);

        for(String ingredient : ingredients){
            builder.ingredients(ingredient);
        }

        return builder.build();


    }

    private static Meal createPizza(String size, boolean extraCheese, String[] ingredients) {
        Pizza.Builder builder = new Pizza.Builder()
                .size(size)
                .extraCheese(extraCheese);

        for(String ingredient : ingredients){
            builder.ingredients(ingredient);
        }

        return builder.build();

    }

}
