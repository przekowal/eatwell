package pl.eatwell.model;

import java.util.Map;

public class Ingredient extends Food  {

    public Ingredient(Food food){
        super(food);
    }

    public Ingredient() {}

    private Map<Nutrition, Float> nutritions;

    private Integer weightInGrams;

    public Integer getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(Integer weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    @Override
    public Map<Nutrition, Float> getNutritions() {
        return nutritions;
    }

    @Override
    public void setNutritions(Map<Nutrition, Float> nutritions) {
        this.nutritions = nutritions;
    }

    //TODO check, move to service or read from db
    public void calculateNutrition(){
        for(Nutrition nutItem: super.getNutritions().keySet()){
            this.nutritions.put(nutItem, super.getNutritions().get(nutItem).floatValue() * this.weightInGrams / 100);
        }
    }
}
