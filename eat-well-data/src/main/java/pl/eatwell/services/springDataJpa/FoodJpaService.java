package pl.eatwell.services.springDataJpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.eatwell.model.Food;
import pl.eatwell.model.Ingredient;
import pl.eatwell.repositories.FoodRepository;
import pl.eatwell.services.FoodService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class FoodJpaService implements FoodService {

    private final FoodRepository foodRepository;

    public FoodJpaService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Food findByName(String name) {
        return null;
    }

    @Override
    public Set<Food> findAll() {
        Set<Food> foods = new HashSet<>();
        foodRepository.findAll().forEach(foods::add);
        return foods;
    }

    @Override
    public Food findById(Long aLong) {
        return foodRepository.findById(aLong).orElse(null);
    }

    @Override
    public Food save(Food object) {
        return foodRepository.save(object);
    }

    @Override
    public void delete(Food object) {
        foodRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        foodRepository.deleteById(aLong);
    }
}
