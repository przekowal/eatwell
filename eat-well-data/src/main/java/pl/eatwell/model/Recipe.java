package pl.eatwell.model;

import java.util.ArrayList;
import java.util.List;

public class Recipe extends Food {

    private User user;
    private String difficulty;
    private ArrayList<Ingredient> ingredients;
    private String imageUrl;

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


}
