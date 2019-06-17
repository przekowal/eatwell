package pl.eatwell.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eatwell.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
