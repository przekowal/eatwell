package pl.eatwell.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.eatwell.model.RecipeType;

import java.util.Optional;

public interface RecipeTypeRepository extends CrudRepository<RecipeType, Long> {

}
