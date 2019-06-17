package pl.eatwell.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Ingredient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Measure measure;

    @OneToOne
    private Food food;

    //TODO initialize, multiply nutrition by weight, not from db
    @Transient
    private Map<Nutrition, Float> nutritions = new HashMap<>();

    @ManyToOne
    private Recipe recipe;

    public Ingredient(Food food, Measure measure){
        this.food = food;
        this.measure = measure;
    }

    public Ingredient(){}

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Map<Nutrition, Float> getNutritions() {
        return nutritions;
    }

    public void setNutritions(Map<Nutrition, Float> nutritions) {
        this.nutritions = nutritions;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    //TODO check, move to service or read from db
    public void calculateNutrition(){
        this.food.getNutritions().forEach((nutrition) -> {
            this.nutritions.put(nutrition, nutrition.getAmount() * this.measure.getWeighInGrams() / 100);
        });
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }
}
