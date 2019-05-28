package pl.eatwell.model;

public class Ingredient extends Food {

    private Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weightInGrams) {
        this.weight = weightInGrams;
    }
}
