package ac.za.cput.controller;
/*
 *@author @joselledina
 * Description: create Home Controller
 * Date: 20 September 2020
 */
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
    @RequestMapping({"/","/index/home"})
    @Bean
    String home(){
        return "Inventory System Application"  ;
    }

}

