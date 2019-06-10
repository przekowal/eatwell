package pl.eatwell.model;

import java.util.Map;

public class Food extends BaseEntity {

    private String name;
    private String description;
    private String category;
    private Boolean glutenFree;
    private Map<Nutrition, Float> nutritions;

    //TODO zastanowic sie jak bedzie z id
    protected Food(Food food){
        this.name = food.name;
        this.description = food.description;
        this.category = food.category;
        this.glutenFree = food.glutenFree;
        this.nutritions = food.nutritions;
    }

    public Food () {}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public Map<Nutrition, Float> getNutritions() {
        return nutritions;
    }

    public void setNutritions(Map<Nutrition, Float> nutritions) {
        this.nutritions = nutritions;
    }
}
