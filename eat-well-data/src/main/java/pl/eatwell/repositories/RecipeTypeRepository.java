package pl.eatwell.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eatwell.model.RecipeType;


public interface RecipeTypeRepository extends CrudRepository<RecipeType, Long> {

}
