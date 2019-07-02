package pl.eatwell.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import pl.eatwell.IndexController;
import pl.eatwell.model.Recipe;
import pl.eatwell.services.FoodService;
import pl.eatwell.services.RecipeService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    IndexController indexController;

    @Mock
    Model model;

    @Mock
    RecipeService recipeService;

    @Mock
    FoodService foodService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService, foodService);
    }

    @Test
    public void testMockMvc() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void getIndexPage(){

        //Given
        Recipe recipe1 = new Recipe();
        recipe1.setName("Chicken");
        Recipe recipe2 = new Recipe();
        recipe2.setName("lamb");
        Set<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe1);
        recipesData.add(recipe2);

        when(recipeService.findAll()).thenReturn(recipesData);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        //When
        String viewName = indexController.getIndexPage(model);

        //Then
        assertEquals("index", viewName);
        verify(recipeService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setIndexContr = argumentCaptor.getValue();
        assertEquals(2, setIndexContr.size());
    }


}
