package ac.za.cput.service.user.impl;

import ac.za.cput.entity.user.Login;
import ac.za.cput.repository.user.LoginRepository;
import ac.za.cput.service.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
/*
 *@author @joselleDina
 * Description: Interface for Login Service
 * Date: 02 September 2020
 */

@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private  LoginRepository repository;


    @Override
    public Set<Login> getAll() {
        return repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Login create(Login login) {
        return repository.save(login);
    }

    @Override
    public Login read(String loginId) {
        return repository.getOne(loginId);
    }

    @Override
    public Login update(Login login) {

        if(this.repository.existsById(login.getLoginId())) {
            return repository.save(login);
        }
        return null;
    }

    @Override
    public boolean delete(String loginId) {
        repository.deleteById(loginId);


        return false;
    }
}
