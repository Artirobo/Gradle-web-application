package spring.gradle.controller;

import spring.gradle.model.User;
import spring.gradle.service.UserService;
import spring.gradle.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by arti on 8/19/17.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;



    @Autowired
    private UserValidator userValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        model.addAttribute("listPersons", this.userService.listPersons());
        return "registration";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {


        if (bindingResult.hasErrors()) {
            return "registration";
        }


        if(userForm.getId()==null){

            System.out.println("yaha aauxa");
            userService.save(userForm);
                }else {
            System.out.println("edit garne bela ma ");
//            yesle ni kaam garxa
//            userService.save(userForm);
            userService.updatePerson(userForm);
        }


        return "redirect:/";

    }


    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") Long id,Model model) {
        model.addAttribute("userForm",this.userService.getPersonById(id));
        model.addAttribute("listPersons", this.userService.listPersons());
    return "registration";
    }

    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") Long id){

        this.userService.removePerson(id);
        return "redirect:/";
    }

}
