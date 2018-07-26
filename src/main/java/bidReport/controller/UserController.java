package bidReport.controller;

import bidReport.UserUpdateDto;
import bidReport.model.User;
import bidReport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by pc-mg on 7/21/2018.
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService, Validator userValidator) {
        this.userService = userService;
    }

    @GetMapping(value = "/list")
    public String list(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping(value = "/create")
    public String getCreate(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping(value = "/create")
    public ModelAndView postCreate(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("user/create");
        }
        userService.save(user);
        return new ModelAndView("redirect: /user/list");
    }

    @GetMapping(value = "/edit/{id}")
    public String getEdit(@PathVariable("id") int id, Model model) {
        Optional<User> user = userService.findById(id);
        user.ifPresent(u -> model.addAttribute("editUser", new User(u)));
        return "user/edit";
    }

    @PostMapping(value = "/edit")
    public ModelAndView edit(@ModelAttribute("editUser") @Valid UserUpdateDto userUpdateDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ModelAndView("user/edit");
        }
        userService.update(userUpdateDto);
        return new ModelAndView("redirect: /user/list");
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        userService.delete(id);
        return "user/list";
    }

}
