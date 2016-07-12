package menu.controller;

import menu.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    BeerService beerService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("beers",beerService.listAll());
        return "index";
    }
}
