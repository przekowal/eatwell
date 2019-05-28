package pl.eatwell.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.eatwell.model.Recipe;
import pl.eatwell.services.FoodService;
import pl.eatwell.services.RecipeService;

@Controller
@RequestMapping("recipes")
public class RecipeController {

    private final RecipeService recipeService;
    private final FoodService foodService;

    public RecipeController(RecipeService recipeService, FoodService foodService) {
        this.recipeService = recipeService;
        this.foodService = foodService;
    }

    @RequestMapping("/recipe1")
    public String recipe1(){
        return "recipes/recipe";
    }

    @RequestMapping({"/", ""})
    public String showRecipe(Model model){

        model.addAttribute("recipes", recipeService.findAll());
        return "recipes";
    }

    @GetMapping("/design")
    public String designRecipe(Model model){

        model.addAttribute("ingredients", foodService.findAll());
        model.addAttribute("design", new Recipe());
        return "recipes/design";
    }

    @PostMapping("/design")
    public String processDesignRecipe(){
        //TODO implement
        return "redirect:current";
    }

    @GetMapping("/current")
    public String showCurrentRecipe(Model model){
        return "recipes/current";
    }
}
