package pl.eatwell.model;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    private Set<Measure> measures;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Nutrition> nutritions;

    //TODO zastanowic sie jak bedzie z id
    protected Food(Food food){
        this.name = food.name;
        this.description = food.description;
        this.category = food.category;
        this.glutenFree = food.glutenFree;
    }

    public Food() {}

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

    public Set<Nutrition> getNutritions() {
        return nutritions;
    }

    public void setNutritions(Set<Nutrition> nutritions) {
        this.nutritions = nutritions;
    }

    public Set<Measure> getMeasures() {
        return measures;
    }

    public void setMeasures(Set<Measure> measures) {
        this.measures = measures;
    }
}
