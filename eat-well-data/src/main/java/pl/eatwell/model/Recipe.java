package pl.eatwell.model;

import java.util.ArrayList;
import java.util.List;

public class Recipe extends Food {

    private String difficulty;
    private ArrayList<Ingredient> ingredients;

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }


}
