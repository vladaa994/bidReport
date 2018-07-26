package bidReport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by pc-mg on 7/19/2018.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        String message = "Welcome to BidReport Software";
        model.addAttribute("message", message);
        return "index";
    }
}
