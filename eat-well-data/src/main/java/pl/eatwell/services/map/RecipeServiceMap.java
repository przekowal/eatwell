package pl.eatwell.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.eatwell.model.Recipe;
import pl.eatwell.services.RecipeService;
import java.util.Set;

@Service
@Profile(("default, map"))
public class RecipeServiceMap extends AbstractMapService<Recipe, Long> implements RecipeService {

    @Override
    public Set<Recipe> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Recipe recipe) {
        super.delete(recipe);
    }

    @Override
    public Recipe save(Recipe recipe) {
        return super.save(recipe);
    }

    @Override
    public Recipe findById(Long id) {
        return super.findById(id);
    }
}
