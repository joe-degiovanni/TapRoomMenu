package menu.controller;

import menu.beer.Beer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

@Controller
public class MenuController{

    @RequestMapping("/beertest")
    public String beer(@RequestParam String name, Model model){
        model.addAttribute("name", name);
        return "beer";
    }

    /**
     * display the beer entry form
     * @param model
     * @return
     */
    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public String enter(Model model){
        return "admin/new";
    }

    /**
     * display the beer entry form
     * @param model
     * @return
     */
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String enterSubmit(@ModelAttribute Beer beer, Model model){
        beer.setName("submitted");
        try {
            this.save(beer, model);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "admin/new";
    }

    /**
     * handle the form submit for an updated beer.
     * @param beer
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/save", consumes = {"text/plain", "application/*"})
    public String save(@RequestBody Beer beer, Model model) throws IOException {
        model.addAttribute("name", beer.getName());
        File file = new File(beer.getName() + ".json");
        file.createNewFile();
        return "save";
    }
}
