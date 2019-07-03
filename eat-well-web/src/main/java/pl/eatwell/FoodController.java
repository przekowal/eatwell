package pl.eatwell;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.eatwell.services.FoodService;

@Controller
@RequestMapping({"/foods"})
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @RequestMapping({"/", ""})
    public String listFoods(Model model){
        model.addAttribute("foods", foodService.findAll());
        return "foods/index";
    }
}
