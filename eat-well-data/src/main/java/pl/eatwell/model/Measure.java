package pl.eatwell.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Measure extends BaseEntity {

    private String description;
    private Double amount;
    private Integer weighInGrams;

    public Measure(String description, Double amount){
        this.description = description;
        this.amount = amount;
        if(description.equalsIgnoreCase("grams")){
            this.weighInGrams = amount.intValue();
        }
    }
}
