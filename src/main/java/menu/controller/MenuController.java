package menu.controller;

import menu.beer.Beer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;

@Controller
public class MenuController{

    @RequestMapping("/beertest")
    public String beer(@RequestParam String name, Model model){
        model.addAttribute("name", name);
        return "beer";
    }

    @RequestMapping("/enter")
    public String enter(Model model){
        return "form";
    }

    @RequestMapping(value = "/save", consumes = {"text/plain", "application/*"})
    public String save(@RequestBody Beer beer, Model model) throws IOException {
        model.addAttribute("name", beer.getName());
        File file = new File(beer.getName() + ".json");
        file.createNewFile();
        return "save";
    }
}
