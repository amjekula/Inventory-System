package ac.za.cput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
    @RequestMapping({"/","/index/home"})
    String home(){
        return "Inventory System Application";
    }
}
