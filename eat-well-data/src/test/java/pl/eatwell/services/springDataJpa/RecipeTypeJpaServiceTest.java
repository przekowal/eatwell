package pl.eatwell.services.springDataJpa;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.eatwell.converters.RecipeCommandToRecipe;
import pl.eatwell.converters.RecipeToRecipeCommand;
import pl.eatwell.model.Recipe;
import pl.eatwell.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeTypeJpaServiceTest {

    RecipeJpaService recipeJpaService;
    
    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeJpaService = new RecipeJpaService(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void findAll() {

        Recipe recipe = new Recipe();
        Set<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeJpaService.findAll();

        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }
}