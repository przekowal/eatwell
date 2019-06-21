package pl.eatwell.services;

import pl.eatwell.model.Food;
import pl.eatwell.model.Ingredient;

public interface FoodService extends CrudService<Food, Long>  {

    Food findByName(String name);
}
