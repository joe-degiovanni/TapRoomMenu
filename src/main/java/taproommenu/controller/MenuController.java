package taproommenu.controller;

import taproommenu.businesslogic.model.Menu;
import taproommenu.businesslogic.service.BeerService;
import taproommenu.businesslogic.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    BeerService beerService;

    @Autowired
    MenuService menuService;

    @RequestMapping(name="", method = RequestMethod.GET)
    public String home(Model model){
        if(!model.containsAttribute("menu")){
            model.addAttribute("menu", new Menu());
        }
        model.addAttribute("menus",menuService.listAll());
        return "menus";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Menu menu, Model model){
        if(menuService.exists(menu)){
            throw new RuntimeException("menu already exists");
        }
        menuService.add(menu);
        return view(menu, model);
    }

    @RequestMapping(value="/delete")
    public String delete(@ModelAttribute Menu menu, Model model){
        menuService.delete(menu);
        return home(model);
    }

    @RequestMapping(value = "/view")
    public String view(@ModelAttribute Menu menu, Model model){
        if(menu.getId() > 0 && menuService.exists(menu)){
            menu = menuService.read(menu);
        }
        model.addAttribute("menu", menu);
        return home(model);
    }

    @RequestMapping(value = "/view/{id}")
    public String view(@PathVariable long id, Model model){
        Menu menu = new Menu();
        if(id > 0 && menuExists(id)){
            menu.setId(id);
            menu = menuService.read(menu);
        } else {
            throw new RuntimeException("menu does not exist");
        }
        model.addAttribute("menu",menu);
        return home(model);
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        Menu menu = new Menu();
        if(id > 0 && menuExists(id)){
            menu.setId(id);
            menu = menuService.read(menu);
        } else {
            throw new RuntimeException("menu does not exist");
        }
        model.addAttribute("menu",menu);
        return "menus/edit";
    }

    @RequestMapping(value = "/update")
    public String update(@ModelAttribute Menu menu, Model model){
        menuService.update(menu);
        return "menus/view";
    }

    private boolean menuExists(long id){
        Menu menu = new Menu();
        menu.setId(id);
        return menuService.exists(menu);
    }
}
