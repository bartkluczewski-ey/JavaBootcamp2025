package designPatterns.builder;

import designPatterns.Meal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pizza implements Meal {

    private final String size;
    private final List<String> ingredients;
    private final boolean extraCheese;

    @Override
    public void prepare() {

    }

    @Override
    public BigDecimal getPrice() {
        return null;
    }

    private Pizza(Builder builder){
        this.size = builder.size;
        this.ingredients = builder.ingredients;
        this.extraCheese = builder.extraCheese;
    }

    public String getSize() {
        return size;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public boolean getExtraCheese() {
        return extraCheese;
    }

    public static class Builder{
        private String size;
        private List<String> ingredients;
        private boolean extraCheese;

        public Builder(){
            ingredients = new ArrayList<>();
        }

        public Pizza.Builder size(String size){
            if(size == null || size.trim().isEmpty()){
                throw new IllegalArgumentException("Size cannot be null or empty");
            }

            this.size = size;
            return this;
        }

        public Pizza.Builder extraCheese(boolean extraCheese){
            this.extraCheese = extraCheese;
            return this;
        }

        public Pizza.Builder ingredients(String ingredients){
            if(ingredients==null || ingredients.trim().isEmpty()){
                throw new IllegalArgumentException("Ingredient cannot be null or empty");
            }

            this.ingredients.add(ingredients);
            return this;

        }

        public Pizza build(){
            return new Pizza(this);
        }

    }
}
