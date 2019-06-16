package pl.eatwell.model;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Ingredient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer weightInGrams;

    @OneToOne
    private Measure measure;

    @OneToOne
    private Food food;

    //private List<Nutrition> nutrition;

    //TODO initialize, multiply nutrition by weight, not from db
    //private Map<Nutrition, Float> nutritions;

    @ManyToOne
    private Recipe recipe;

    public Integer getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(Integer weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

   /* public List<Nutrition> getNutrition() {
        return nutrition;
    }

    public void setNutrition(List<Nutrition> nutrition) {
        this.nutrition = nutrition;
    }*/

    /*public Map<Nutrition, Float> getNutritions() {
        return nutritions;
    }

    public void setNutritions(Map<Nutrition, Float> nutritions) {
        this.nutritions = nutritions;
    }*/

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
/*    public void calculateNutrition(){
        for(Nutrition nutItem: super.getNutritions().keySet()){
            this.nutritions.put(nutItem, super.getNutritions().get(nutItem).floatValue() * this.weightInGrams / 100);
        }
    }*/

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }
}
