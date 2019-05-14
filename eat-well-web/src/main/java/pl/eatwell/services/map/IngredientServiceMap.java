package pl.eatwell.services.map;

import org.springframework.stereotype.Service;
import pl.eatwell.model.Ingredient;
import pl.eatwell.services.IngredientService;

import java.util.Set;

@Service
public class IngredientServiceMap extends AbstractMapService<Ingredient, Long> implements IngredientService {

    @Override
    public Set<Ingredient> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Ingredient ingredient) {
        super.delete(ingredient);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return super.save(ingredient.getId(), ingredient);
    }

    @Override
    public Ingredient findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Ingredient findByName(String name) {
        //TODO
        return null;
    }
}
