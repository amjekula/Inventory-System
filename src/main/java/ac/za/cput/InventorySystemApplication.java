package ac.za.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class InventorySystemApplication {
    @RequestMapping({"/","/home"})
    String home(){
        return "Inventory System Application";
    }
    public static void main(String[] args) {
        SpringApplication.run(InventorySystemApplication.class, args);
    }
}
