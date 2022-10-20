package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.Errors;

import javax.validation.Valid;

@Controller
@RequestMapping ("user")
public class UserController {

    @GetMapping ("/add")
    private String displayAddUserForm(Model model){
        model.addAttribute(new User());
        return "user/add";
    }

    //Now that you’re passing in an empty User object,
    // you may notice some redundant code in your
    // processAddUserForm controller.
    // Remove the model attribute additions and
    // update the user/add template
    // to make use of the model fields (eg. user.username).


    //Check that the verify parameter matches
    // the password within the user object.
    // If it does, render the user/index.html view template with a
    // message that welcomes the user by username. HELP!!
    // If the passwords don’t match, render the form again.

    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {

        if (errors.hasErrors()){
            model.addAttribute("error", "Passwords do not match.");
            return "user/add";
        }

        else if (user.getPassword().equals(verify)) {
            model.addAttribute("error", "Passwords do not match.");
            return "user/add";
        }

        else {
            return "user/index";
        }
    }
}