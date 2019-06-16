package pl.eatwell.model;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Food extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String category;
    private Boolean glutenFree;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Measure> measures;

    //@ElementCollection(targetClass=Nutrition.class)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "food")
    private List<Nutrition> nutritions;

    //TODO zastanowic sie jak bedzie z id
    protected Food(Food food){
        this.name = food.name;
        this.description = food.description;
        this.category = food.category;
        this.glutenFree = food.glutenFree;
    }

    public Food () {}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(Boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

   /* public List<Nutrition> getNutritions() {
        return nutritions;
    }

    public void setNutritions(List<Nutrition> nutritions) {
        this.nutritions = nutritions;
    }*/
}
