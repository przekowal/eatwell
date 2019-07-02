package pl.eatwell.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.eatwell.model.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {


}
