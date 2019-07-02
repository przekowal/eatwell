package pl.eatwell.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.eatwell.model.Food;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {
}
