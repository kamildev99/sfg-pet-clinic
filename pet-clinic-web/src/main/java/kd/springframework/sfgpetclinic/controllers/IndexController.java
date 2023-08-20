package kd.springframework.sfgpetclinic.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    //search for file template index
    //list of parameters
    @RequestMapping({"", "/", "index","index.html"})
    public String index(){

        return "index";
    }
}
