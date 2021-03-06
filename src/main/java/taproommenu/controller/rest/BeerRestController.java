package taproommenu.controller.rest;

import taproommenu.businesslogic.model.Beer;
import taproommenu.businesslogic.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/beer", produces = "application/json")
public class BeerRestController {

    @Autowired
    private BeerService beerService;

    /**
     * List all active beers
     * @return a JSON formatted string of all active beers in the taproom
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Beer> list(){
        return beerService.listAll();
    }

    /**
     * Read one beer by id
     * @param id the id of the beer to read.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Beer read(@PathVariable Integer id) {
        Beer key = new Beer();
        key.setId(id);
        return beerService.read(key);
    }

    /**
     * Read one beer by name
     * @param name the name of the beer to read.
     */
    @RequestMapping(value = "/byName/{name}", method = RequestMethod.GET)
    public Beer readByName(@PathVariable String name) {
        Beer key = new Beer();
        key.setName(name);
        return beerService.readByName(key);
    }
}
