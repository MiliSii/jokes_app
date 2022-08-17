package com.example.jokes_app.controllers;

import com.example.jokes_app.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    //set up final property for the joke service, final means that it can never be changed by something else in the class
    private final JokeService jokeService;
    //creating a constructor which will initialize the JokeService
    //@Autowired don't need for this
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }


    //implement controller method
    @RequestMapping({"/",""})
    public String showJokes(Model model){
        model.addAttribute("jokes", jokeService.getJoke());
        return "index";
//we're adding in an attribute to the model with the property of joke, and then we'll
//add the joke string from the joke service, and then we return the string index. That's going
//to tell Spring MVC that we want to do the index view.
    }
}
