package ac.za.cput.repository.user.impl;

import ac.za.cput.entity.user.Login;
import ac.za.cput.repository.user.LoginRepository;

import java.util.HashSet;
import java.util.Set;

public class LoginRepositoryImpl implements LoginRepository {
    private static LoginRepository repository = null;
    private Set<Login> loginDB;


    LoginRepositoryImpl() {
        this.loginDB = new HashSet<>();
    }

    public static LoginRepository getLoginRepository(){
        if(repository == null) repository = new LoginRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Login> getAll() {
        return this.loginDB;
    }

    @Override
    public Login create(Login login) {
        this.loginDB.add(login);
        return login;
    }

    @Override
    public Login read(String loginId) {
        Login login = null;

        for(Login log : this.loginDB){
            if(log.getLoginId().equalsIgnoreCase(loginId)){
                login = log;
                break;
            }
        }
        return login;
    }

    @Override
    public Login update(Login login) {
        Login oldLogin = read(login.getLoginId());

        if(oldLogin != null){
            this.loginDB.remove(oldLogin);
            this.loginDB.add(login);
        }
        return login;
    }

    @Override
    public void delete(String loginId) {
        Login login = read(loginId);
        if(login != null){
            this.loginDB.remove(login);
        }

    }
}
