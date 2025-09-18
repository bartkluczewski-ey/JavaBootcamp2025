package designPatterns.builder;

import designPatterns.Meal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Burger implements Meal {

    private final String size;
    private final List<String> ingredients;
    private final String sauceType;

    @Override
    public void prepare() {

        System.out.println("Creating burger: "+size+" with sauce "+sauceType);
        System.out.println("Ingredients: "+ingredients);
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal("25.99");
    }

    private Burger(Builder builder){
        this.size = builder.size;
        this.ingredients = builder.ingredients;
        this.sauceType = builder.sauceType;
    }

    public String getSize() {
        return size;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getSauceType() {
        return sauceType;
    }

    public static class Builder{
        private String size;
        private final List<String> ingredients;
        private String sauceType;

        public Builder(){
            ingredients = new ArrayList<>();
        }

        public Builder size(String size){
            if(size == null || size.trim().isEmpty()){
                throw new IllegalArgumentException("Size cannot be null or empty");
            }

            this.size = size;
            return this;
        }

        public Builder sauceType(String sauceType){
            if(sauceType == null || sauceType.trim().isEmpty()){
                throw new IllegalArgumentException("Sauce type cannot be null or empty");
            }
            this.sauceType = sauceType;
            return this;
        }

        public Builder ingredients(String ingredients){
            if(ingredients==null || ingredients.trim().isEmpty()){
                throw new IllegalArgumentException("Ingredient cannot be null or empy");
            }

            this.ingredients.add(ingredients);
            return this;

        }

        public Burger build(){
            return new Burger(this);
        }

    }






}
