package pl.eatwell.model;

import lombok.*;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class FoodCategory extends BaseEntity {

    private String category;

    public FoodCategory(String category){
        this.category = category;
    }

}
