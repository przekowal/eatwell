package pl.eatwell.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eatwell.model.Food;

public interface FoodRepository extends CrudRepository<Food, Long> {
}
