package ac.za.cput.controller.user;


import ac.za.cput.entity.user.Login;
import ac.za.cput.factory.user.LoginFactory;
import ac.za.cput.service.user.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginServiceImpl loginService;

    //    @RequestMapping(value = "/create", method = RequestMethod.)
    @PostMapping("/create")
    public Login create(@RequestBody Login login) {

        Login newLogin = LoginFactory.createLogin(login.getEmailAddress(), login.getPassword());
        return loginService.create(newLogin);
    }

    @GetMapping("/all")
    public Set<Login> getAll(){
        return loginService.getAll();
    }

    @DeleteMapping("/delete/{loginId}")
    public void delete(@PathVariable String loginId)
    {
        loginService.delete(loginId);
    }
    @PostMapping("/update")
    public Login update(@RequestBody Login login){
        return loginService.update(login);
    }

    @GetMapping("/read/{loginId}")
    public Login read(@PathVariable String loginId)
    {
        return loginService.read(loginId);
    }
}
