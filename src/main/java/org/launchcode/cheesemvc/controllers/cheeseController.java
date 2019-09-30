package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("cheese")
public class cheeseController {
   //static ArrayList <String> cheeses = new ArrayList<>();
   static HashMap <String , String> cheeses = new HashMap<>();
    @RequestMapping(value = "")
    public String index(Model model){


        model.addAttribute("cheeses",cheeses);
        model.addAttribute("title","My Cheeses");
        return "cheese/index";
    }
     @RequestMapping(value="add",method = GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("title","Add Cheese");
        return "cheese/add";
     }
    @RequestMapping(value="add", method = POST)
    public String addCheese(@RequestParam String name,@RequestParam String description){
       cheeses.put(name,description);
       return "redirect:";
    }
}
