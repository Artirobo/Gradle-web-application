package spring.gradle.controller;

import spring.gradle.model.ModelRegistration;
import spring.gradle.service.ModelRegister;
import spring.gradle.validator.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by arti on 8/27/17.
 */
@Controller
public class SecurityControllerController {


    @Autowired
    private ModelRegister register;


    @Autowired
    private RegisterValidator userValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }


    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Custom Login Form");
        model.addObject("message", "This is protected page!");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();


        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }

        model.setViewName("formlogin");

        return model;

    }


    //for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();

        //check if user is login
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            System.out.println(userDetail);

            model.addObject("username", userDetail.getUsername());

        }

        model.setViewName("403");
        return model;

    }

//    @RequestMapping(value = "/register",method = RequestMethod.GET)
//    public ModelAndView register(Model model){
//        ModelAndView model1 = new ModelAndView();
//        model.addAttribute("modelForm", new ModelRegistration());
//        model1.addObject("title", "Regestration");
//        model1.addObject("message", "Custom page Regestration");
//        model1.setViewName("formRegisterLogin");
//        return model1;
//
//    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView register() {

        ModelAndView model = new ModelAndView();

    model.setViewName("formRegisterLogin");
        model.addObject("title","Registration");
        model.addObject("message","welcome");
          model.addObject("usereg", new ModelRegistration());
        return model;


    }



    //yo register garna ko lagi

    @RequestMapping(value = "/addregistration",method = RequestMethod.POST)
    public String registrationCustom(@Valid @ModelAttribute ("usereg") ModelRegistration modelRegistration, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            return "formRegisterLogin";
        }


        String hashedPassword = passwordEncoder.encode(modelRegistration.getPassword());

if(modelRegistration.getUsername()!=null){
        modelRegistration.setEnable(1);
    modelRegistration.setPassword(hashedPassword);
    register.save(modelRegistration);

}else{

    return "regirect:/register";
}




        return "redirect:/login";
    }

}