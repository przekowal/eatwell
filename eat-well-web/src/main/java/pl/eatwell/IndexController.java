package pl.eatwell;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.eatwell.services.FoodService;
import pl.eatwell.services.RecipeService;

@Controller
public class IndexController {

    private final RecipeService recipeService;
    private final FoodService foodService;

    public IndexController(RecipeService recipeService, FoodService foodService) {
        this.recipeService = recipeService;
        this.foodService = foodService;
    }

    @RequestMapping({"/", "", "index", "index.html"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes", recipeService.findAll());
        return "index";
    }

    //TODO just to let intellij see recipes object in fragment page
    @RequestMapping({"/fake"})
    public String showRecipe(Model model){
        model.addAttribute("recipes", recipeService.findAll());
        return "fragments/recipes";
    }
}
