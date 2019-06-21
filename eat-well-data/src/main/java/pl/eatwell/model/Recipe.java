package pl.eatwell.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@EqualsAndHashCode(exclude =
        {"ingredients", "image", "recipeTypes", "nutritions", "directions", "user"})
@Data
public class Recipe extends BaseEntity {

    private String name;
    private String description;

    //TODO initialize
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private List<Ingredient> ingredients = new ArrayList<>();

    private Integer preparationTime;
    private Integer cookingTime;
    private String sourceUrl;
    private String imageUrl;
    @Lob
    private Byte[] image;
    private LocalDate date;
    private Integer servings;

    @ManyToMany
    @JoinTable(name = "recipe_recipeType",
        joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipeType_id"))
    private Set<RecipeType> recipeTypes;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private Directions directions;

    @ManyToOne
    private User user;

    @Transient
    private Map<Nutrition, Float> nutritions = new HashMap<>();

    public void calculateNutrition(){

        this.ingredients.forEach(Ingredient::calculateNutrition);

       float totalEnergy = 0;
       float totalProtein = 0;
       float totalCarbs = 0;
       float totalFat = 0;

       for(Ingredient ingredient: this.ingredients){
           ingredient.calculateNutrition();
           for(Map.Entry<Nutrition, Float> entry: ingredient.getNutritions().entrySet()){
               if(entry.getKey().getName().equals("calories")){
                   totalEnergy += entry.getValue();
                   this.nutritions.put(entry.getKey(), totalEnergy);
               } else if(entry.getKey().getName().equals("protein")){
                   totalProtein += entry.getValue();
                   this.nutritions.put(entry.getKey(), totalProtein);
               } else if (entry.getKey().getName().equals("carb")){
                   totalCarbs += entry.getValue();
                   this.nutritions.put(entry.getKey(), totalCarbs);
               } else if (entry.getKey().getName().equals("fat")){
                   totalFat += entry.getValue();
                   this.nutritions.put(entry.getKey(), totalFat);
               }
           }
       }
    }

    public Recipe addIngredient(Ingredient ingredniet){
        ingredniet.setRecipe(this);
        this.ingredients.add(ingredniet);
        return this;
    }

    public void setDirections(Directions directions) {
        this.directions = directions;
        directions.setRecipe(this);
    }
}
