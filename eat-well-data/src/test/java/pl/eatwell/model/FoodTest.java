package pl.eatwell.model;



import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FoodTest {

    private List<Food> foods;

    @Before
    public void setup(){
        this.foods = FoodUtils.getFullListOfSixFoods();
    }

    @Test
    public void listShouldContainSixFiids(){
        assertEquals("Sould be six", 6, foods.size());
    }

    @Test
    public void foodNbFiveShouldHaveMeasure100Grams(){
        Food food5 = foods.get(4);
        assertEquals("Should be 100 grams",
                100, food5.getMeasures().stream().findAny().get().getWeighInGrams().intValue());
    }

    @Test
    public void foodNbFourShouldHaveProtein100Grams(){
        Food food4 = foods.get(3);
        assertEquals("Should be 30 grams of protein",
                30, food4.getNutritions().stream()
                        .filter(n -> n.getName().equalsIgnoreCase("protein"))
                        .findAny().get().getAmount().intValue());
    }
}
