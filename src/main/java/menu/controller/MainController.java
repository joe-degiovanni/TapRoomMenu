package menu.controller;

import menu.model.beer.Beer;
import menu.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    BeerService beerService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("beer", new Beer());
        model.addAttribute("beers",beerService.listAll());
        return "index";
    }

    @RequestMapping(name = "/addBeer", method = RequestMethod.POST)
    public String addBeer(@ModelAttribute Beer beer, Model model){
        beerService.add(beer);
        model.addAttribute("beer", new Beer());
        model.addAttribute("beers",beerService.listAll());
        return "index";
    }
}
