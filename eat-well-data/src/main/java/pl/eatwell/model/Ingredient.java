package pl.eatwell.model;

public class Ingredient  {

    private Food food;

    private Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weightInGrams) {
        this.weight = weightInGrams;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
