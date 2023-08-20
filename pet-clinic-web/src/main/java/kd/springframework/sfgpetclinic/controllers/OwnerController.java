package kd.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//trick to short path above method
@RequestMapping("/owners")
@Controller
public class OwnerController {


    @RequestMapping({"", "/index", "/index.html", "/"})
    public String ownersList(){

        return "owners/index";
    }
}
