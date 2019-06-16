package pl.eatwell.model;

import javax.persistence.*;

@Entity
public class Measure extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Float weighInGrams;

    @ManyToOne
    private Food food;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getWeighInGrams() {
        return weighInGrams;
    }

    public void setWeighInGrams(Float weighInGrams) {
        this.weighInGrams = weighInGrams;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}
