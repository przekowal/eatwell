package pl.eatwell.model;

import java.util.Map;

public class Food extends BaseEntity {


    private String name;
    private String description;
    private String category;
    private Boolean glutenFree;
    private Map<Nutrition, Integer> nutritions;

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

    public Map<Nutrition, Integer> getNutritions() {
        return nutritions;
    }

    public void setNutritions(Map<Nutrition, Integer> nutritions) {
        this.nutritions = nutritions;
    }
}
