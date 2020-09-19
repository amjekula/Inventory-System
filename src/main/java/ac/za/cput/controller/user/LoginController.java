package ac.za.cput.controller.user;


import ac.za.cput.entity.user.Login;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

//    @RequestMapping(value = "/create", method = RequestMethod.)
    @PostMapping("/create")
    public String create(){
        return "hi";


    }

}
