package ac.za.cput.service.user.impl;

import ac.za.cput.entity.user.Login;
import ac.za.cput.repository.user.LoginRepository;
import ac.za.cput.repository.user.impl.LoginRepositoryImpl;
import ac.za.cput.service.user.LoginService;

import java.util.Set;
/*
 *@author @joselleDina
 * Description: Interface for Login Service
 * Date: 02 September 2020
 */

public class LoginServiceImpl implements LoginService {

    private static LoginService service = null;
    private  LoginRepository repository;
    private LoginServiceImpl(){
        this.repository = LoginRepositoryImpl.getLoginRepository();
    }

    public static LoginService getService(){
        if(service == null){
            service = new LoginServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Login> getAll() {
        return repository.getAll();
    }

    @Override
    public Login create(Login login) {
        return repository.create(login);
    }

    @Override
    public Login read(String loginId) {
        return repository.read(loginId);
    }

    @Override
    public Login update(Login login) {
        return repository.update(login);
    }

    @Override
    public void delete(String loginId) {
        repository.delete(loginId);

    }
}
