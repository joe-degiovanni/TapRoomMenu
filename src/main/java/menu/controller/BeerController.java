package menu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import menu.beer.Beer;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/beer", produces = "application/json")
public class BeerController {

    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

    /**
     * List all active beers
     * @return a JSON formatted string of all active beers in the taproom
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(){
        return "list method not implemented yet";
    }

    /**
     * Read one beer config file by name
     * @param name the name of the beer to read. This should match the filename of the JSON file excluding the ".json" extension
     * @return the contents of the JSON file for the specified name. For example, if "fat-tire" is specified, return the contents of fat-tire.json
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String read(@PathVariable String name) throws JsonProcessingException {
        Beer beer = new Beer();
        beer.setName(name);
        return mapper.writeValueAsString(beer);
    }

}
