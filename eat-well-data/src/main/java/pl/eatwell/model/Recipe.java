package pl.eatwell.model;

import java.util.List;

public class Recipe extends Food {

    private String difficulty;
    private List<Food> ingredients;

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public List<Food> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Food> ingredients) {
        this.ingredients = ingredients;
    }


}
