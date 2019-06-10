package pl.eatwell.services.map;

import org.springframework.stereotype.Service;
import pl.eatwell.model.RecipeType;
import pl.eatwell.services.RecipeTypeService;

import java.util.Set;

@Service
public class RecipeTypeMapService extends AbstractMapService<RecipeType, Long> implements RecipeTypeService {

    @Override
    public Set<RecipeType> findAll() {
        return super.findAll();
    }

    @Override
    public RecipeType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public RecipeType save(RecipeType object) {
        return super.save(object);
    }

    @Override
    public void delete(RecipeType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
