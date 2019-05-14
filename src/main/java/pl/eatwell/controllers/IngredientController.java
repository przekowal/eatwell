package pl.eatwell.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.eatwell.services.IngredientService;

@Controller
@RequestMapping({"/ingredients"})
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @RequestMapping({"/", ""})
    public String showRecipe(Model model){
        return "ingredient";
    }
}
