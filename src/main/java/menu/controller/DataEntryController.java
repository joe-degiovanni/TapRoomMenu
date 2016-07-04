package menu.controller;

import org.springframework.http.HttpRequest;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/data")
public class DataEntryController {

    @RequestMapping("/beer")
    public String acceptData(HttpServletRequest servletRequest, @RequestBody RequestEntity<?> body){
        return "whoops";
    }
}
