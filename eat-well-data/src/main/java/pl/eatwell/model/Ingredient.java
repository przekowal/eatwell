package pl.eatwell.model;

public class Ingredient extends Food  {

    public Ingredient(Food food){
        super(food);
    }

    public Ingredient() {}

    private Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weightInGrams) {
        this.weight = weightInGrams;
    }
}
