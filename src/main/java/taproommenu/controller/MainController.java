package taproommenu.controller;

import taproommenu.businesslogic.model.Beer;
import taproommenu.businesslogic.model.Menu;
import taproommenu.businesslogic.service.BeerService;
import taproommenu.businesslogic.service.MenuService;
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

    @Autowired
    MenuService menuService;

    @RequestMapping(name="", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("beer", new Beer());
        model.addAttribute("beers",beerService.listAll());
        model.addAttribute("menu", new Menu());
        model.addAttribute("menus",menuService.listAll());
        return "index";
    }

    @RequestMapping(value="/addBeer", method = RequestMethod.POST)
    public String addBeer(@ModelAttribute Beer beer, Model model){
        beerService.add(beer);
        return home(model);
    }

    @RequestMapping(value="/deleteBeer")
    public String deleteBeer(@ModelAttribute Beer beer, Model model){
        beerService.delete(beer);
        return home(model);
    }

    @RequestMapping(value="/addMenu", method = RequestMethod.POST)
    public String addBeer(@ModelAttribute Menu menu, Model model){
        menuService.add(menu);
        return home(model);
    }

    @RequestMapping(value="/deleteMenu")
    public String deleteBeer(@ModelAttribute Menu menu, Model model){
        menuService.delete(menu);
        return home(model);
    }

    @RequestMapping(value = "/viewMenu")
    public String viewMenu(Model model){
        model.addAttribute("menus", menuService.listAll());
        return "menus";
    }
}
