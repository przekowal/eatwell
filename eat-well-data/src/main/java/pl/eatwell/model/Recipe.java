package pl.eatwell.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
public class Recipe extends BaseEntity {

    //TODO how to make it from Base Entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    //TODO initialize
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private List<Ingredient> ingredients = new ArrayList<>();

    private Integer preparationTime;
    private Integer cookingTime;
    private String sourceUrl;
    private String imageUrl;
    @Lob
    private Byte[] image;
    private LocalDate date;

    @ManyToMany
    @JoinTable(name = "recipe_recipeType",
        joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "recipeType_id"))
    private Set<RecipeType> recipeTypes;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private Directions directions;

    @ManyToOne
    private User user;

    @Transient
    private Map<Nutrition, Float> nutritions = new HashMap<>();

    public void calculateNutrition(){

        this.ingredients.forEach(Ingredient::calculateNutrition);

       float totalEnergy = 0;
       float totalProtein = 0;
       float totalCarbs = 0;
       float totalFat = 0;

       for(Ingredient ingredient: this.ingredients){
           ingredient.calculateNutrition();
           for(Map.Entry<Nutrition, Float> entry: ingredient.getNutritions().entrySet()){
               if(entry.getKey().getName().equals("calories")){
                   totalEnergy += entry.getValue();
                   this.nutritions.put(entry.getKey(), totalEnergy);
               } else if(entry.getKey().getName().equals("protein")){
                   totalProtein += entry.getValue();
                   this.nutritions.put(entry.getKey(), totalProtein);
               } else if (entry.getKey().getName().equals("carb")){
                   totalCarbs += entry.getValue();
                   this.nutritions.put(entry.getKey(), totalCarbs);
               } else if (entry.getKey().getName().equals("fat")){
                   totalFat += entry.getValue();
                   this.nutritions.put(entry.getKey(), totalFat);
               }
           }
       }
    }

    public Recipe addIngredient(Ingredient ingredniet){
        ingredniet.setRecipe(this);
        this.ingredients.add(ingredniet);
        return this;
    }

    public void setDirections(Directions directions) {
        this.directions = directions;
        directions.setRecipe(this);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }


    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setRecipeTypes(Set<RecipeType> recipeTypes) {
        this.recipeTypes = recipeTypes;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public Directions getDirections() {
        return directions;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
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

    public Set<RecipeType> getRecipeTypes() {
        return recipeTypes;
    }

    public Map<Nutrition, Float> getNutritions() {
        return nutritions;
    }

    public void setNutritions(Map<Nutrition, Float> nutritions) {
        this.nutritions = nutritions;
    }
}
