package pl.eatwell.model;


import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

@Entity
@EqualsAndHashCode(exclude =
        {"ingredients", "image", "recipeTypes", "nutritions", "directions", "user", "image"})
@Getter
@Setter
@ToString(exclude = {"recipeTypes", "nutritions", "ingredients"})
public class Recipe extends BaseEntity {

    private String name;
    private String description;

    //TODO initialize
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private List<Ingredient> ingredients = new ArrayList<>();

    private Duration preparationTime;
    private Duration cookingTime;
    private String sourceUrl;
    private Integer servings;
    private String imageUrl;
    @Lob
    private Byte[] image;
    private LocalDate date;


    @ManyToMany
    @JoinTable(name = "recipe_recipeType",
        joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipeType_id"))
    private Set<RecipeType> recipeTypes;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private Directions directions;

    //@ManyToOne(cascade = CascadeType.DETACH)
    //@Transient
    //private User user;

    @Transient
    private Map<Nutrition, Double> nutritions = new HashMap<>();

    //To jest chyba zrabane,
    public void calculateNutrition(){

        //this.ingredients.forEach(Ingredient::calculateNutrition);
        //this.ingredients.stream().forEach(i -> i.calculateNutrition());
      /*  for(Ingredient i : this.ingredients){
            i.calculateNutrition();
        }*/

       double totalEnergy = 0;
       double totalProtein = 0;
       double totalCarbs = 0;
       double totalFat = 0;

       for(Ingredient ingredient: this.ingredients){
           ingredient.calculateNutrition();
           //iteruje po mapie tora jest pusta
           for(Map.Entry<Nutrition, Double> entry: ingredient.getNutritions().entrySet()){
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
