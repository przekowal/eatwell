package pl.eatwell;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.eatwell.commands.RecipeCommand;
import pl.eatwell.model.Recipe;
import pl.eatwell.services.FoodService;
import pl.eatwell.services.RecipeService;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;
    private final FoodService foodService;

    public RecipeController(RecipeService recipeService, FoodService foodService) {
        this.recipeService = recipeService;
        this.foodService = foodService;
    }



    @RequestMapping("/recipe/{id}/show")
    public String getRecipeById(@PathVariable Long id, Model model){
        Recipe recipe = recipeService.findById(id);
        //TODO: mock nutritions
        recipe.calculateNutrition();
        model.addAttribute("recipe", recipe);
        return "recipes/recipe";
    }

    @GetMapping
    @RequestMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        return "recipes/recipeForm";
    }

    @PostMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){

        log.info("Recipe command cooking: " + command.getCookingTime());
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedCommand.getId() + "/show" ;

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
