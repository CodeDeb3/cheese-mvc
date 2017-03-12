package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by Debbie on 3/11/2017.
 */

@Controller
@RequestMapping("cheese") // base request path to be "/cheese"
public class CheeseController {

    // makes the list accesible to all methods below

    static ArrayList<String> cheeses = new ArrayList<>();

    // Request path: /cheese
    @RequestMapping(value = "") // location of html route handler
    public String index(Model model) {

//        ArrayList<String> cheeses = new ArrayList<>();
//        cheeses.add("cheddar");
//        cheeses.add("munster");
//        cheeses.add("parmesan");

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title","My Cheeses");
        return "cheese/index";
    }

    // display the form
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";

    }
    //process the form at same URL "add"
    @RequestMapping(value= "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName) {
        cheeses.add(cheeseName);

        // Redirect to /cheese/
        return "redirect:";

        //get data out of request
//        String cheeseName = request.getParmater("cheeseName");


    }
}
