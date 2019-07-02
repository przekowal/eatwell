package pl.eatwell.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.eatwell.model.RecipeType;

@Repository
public interface RecipeTypeRepository extends CrudRepository<RecipeType, Long> {

}
