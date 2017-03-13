package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

/**
 * Created by Debbie on 3/11/2017.
 */

@Controller
@RequestMapping("cheese") // base request path to be "/cheese"
public class CheeseController {

    // makes the list accesible to all methods below

    static HashMap<String, String> cheeses = new HashMap<>();

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

    // Request Path ; GET /cheese/add
    // display the form
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";

    }
    //process the form at same URL "add"
    //get data out of request using .getparameter ( if arraylist)
    //String cheeseName = request.getParmater("cheeseName");
    // Request path : POST /cheese/add

    @RequestMapping(value= "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String description) {
        cheeses.put(cheeseName, description);
        // Redirect to /cheese/  ie index
        return "redirect:";
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String displayDeleteForm (Model model) {
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");

        return "cheese/delete";
    }

    // Request PATh : POST / cheese/delete
    // using POST instead of GET does not allow for user to mistakenly delete items
    // Deletes cheese
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String deleteCheese (@RequestParam String cheesetoDelete) {
        cheeses.remove(cheesetoDelete);
        //redirect to /cheese
        return "redirect:";
    }
}
