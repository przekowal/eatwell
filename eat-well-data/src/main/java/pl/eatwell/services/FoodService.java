package pl.eatwell.services;

import pl.eatwell.model.Food;
import pl.eatwell.model.Ingredient;

public interface FoodService extends CrudService<Food, Long>  {

    Ingredient findByName(String name);
}
