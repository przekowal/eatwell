package pl.eatwell.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.eatwell.services.RecipeServiceOld;

@Controller
public class RecipeController {

    private final RecipeServiceOld recipeService;

    public RecipeController(RecipeServiceOld recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/", ""})
    public String showRecipe(Model model){

        model.addAttribute("recipe", recipeService.makeRandomRecipe());
        return "recipe";
    }
}
