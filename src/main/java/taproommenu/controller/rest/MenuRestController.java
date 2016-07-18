package taproommenu.controller.rest;

import taproommenu.businesslogic.model.Menu;
import taproommenu.businesslogic.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/menu", produces = "application/json")
public class MenuRestController {

    @Autowired
    private MenuService menuService;

    /**
     * List all active menus
     * @return a JSON formatted string of all active menus in the taproom
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Menu> list(){
        return menuService.listAll();
    }

    /**
     * Read one menu by id
     * @param id the id of the menu to read.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Menu read(@PathVariable Integer id) {
        Menu key = new Menu();
        key.setId(id);
        return menuService.read(key);
    }

    /**
     * Read one menu by name
     * @param name the name of the menu to read.
     */
    @RequestMapping(value = "/byName/{name}", method = RequestMethod.GET)
    public Menu readByName(@PathVariable String name) {
        Menu key = new Menu();
        key.setName(name);
        return menuService.readByName(key);
    }
}
