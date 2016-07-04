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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(){
        return "list method not implemented yet";
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String read(@PathVariable String name) throws JsonProcessingException {
        Beer beer = new Beer();
        beer.setName(name);
        return mapper.writeValueAsString(beer);
    }

}
