package pl.eatwell.model;

import javax.persistence.*;

@Entity
public class Measure extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Float amount;

    private Integer weighInGrams;

    public Measure(String description, Float amount){
        this.description = description;
        this.amount = amount;
        if(description.equalsIgnoreCase("grams")){
            this.weighInGrams = amount.intValue();
        }
    }

    public Measure(){}

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

    public Integer getWeighInGrams() {
        return weighInGrams;
    }

    public void setWeighInGrams(Integer weighInGrams) {
        this.weighInGrams = weighInGrams;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
