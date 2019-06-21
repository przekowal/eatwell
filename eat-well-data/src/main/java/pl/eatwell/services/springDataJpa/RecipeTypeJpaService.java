package pl.eatwell.services.springDataJpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.eatwell.model.RecipeType;
import pl.eatwell.repositories.RecipeRepository;
import pl.eatwell.repositories.RecipeTypeRepository;
import pl.eatwell.services.RecipeTypeService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
@Slf4j
public class RecipeTypeJpaService implements RecipeTypeService {

    private final RecipeTypeRepository recipeTypeRepository;

    public RecipeTypeJpaService(RecipeTypeRepository recipeTypeRepository) {
        this.recipeTypeRepository = recipeTypeRepository;
    }

    @Override
    public Set<RecipeType> findAll() {
        log.debug("Find all recipes");
        Set<RecipeType> recipeTypes = new HashSet<>();
        recipeTypeRepository.findAll().forEach(recipeTypes::add);
        return recipeTypes;
    }

    @Override
    public RecipeType findById(Long aLong) {
        return recipeTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public RecipeType save(RecipeType object) {
        return recipeTypeRepository.save(object);
    }

    @Override
    public void delete(RecipeType object) {
        recipeTypeRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        recipeTypeRepository.deleteById(aLong);
    }
}
