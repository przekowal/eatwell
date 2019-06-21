package pl.eatwell.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.eatwell.model.Food;
import pl.eatwell.model.Ingredient;
import pl.eatwell.services.FoodService;

import java.util.Set;

@Service
@Profile(("default, map"))
public class FoodServiceMap extends AbstractMapService<Food, Long> implements FoodService {

    @Override
    public Set<Food> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Food ingredient) {
        super.delete(ingredient);
    }

    @Override
    public Food save(Food food) {
        return super.save(food);
    }

    @Override
    public Food findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Food findByName(String name) {
        //TODO
        return null;
    }
}
