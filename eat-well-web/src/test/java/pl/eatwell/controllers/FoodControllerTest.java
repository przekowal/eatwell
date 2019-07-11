package pl.eatwell.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.eatwell.FoodController;
import pl.eatwell.model.Food;
import pl.eatwell.services.FoodService;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class FoodControllerTest {

    @Mock
    FoodService foodService;

    @InjectMocks
    FoodController controller;

    Set<Food> foods;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        foods = new HashSet<>();
        foods.add(Food.builder().name("onion").id(1L).build());
        foods.add(Food.builder().name("chicken").id(2L).build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void listFoods() throws Exception {

        when(foodService.findAll()).thenReturn(foods);

        mockMvc.perform(get("/foods"))
                .andExpect(status().isOk())
                .andExpect(view().name("foods/index"))
                .andExpect(model().attribute("foods", hasSize(2)));

    }
}