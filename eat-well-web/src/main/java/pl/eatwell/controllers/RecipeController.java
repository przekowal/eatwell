package pl.eatwell.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.eatwell.services.RecipeService;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/", ""})
    public String showRecipe(Model model){

        model.addAttribute("recipes", recipeService.findAll());
        return "recipes/recipe";
    }
}
