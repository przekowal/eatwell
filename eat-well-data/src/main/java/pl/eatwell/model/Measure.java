package pl.eatwell.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Measure extends BaseEntity {

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
}
