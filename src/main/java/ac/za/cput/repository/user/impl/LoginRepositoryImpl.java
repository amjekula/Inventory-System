package ac.za.cput.repository.user.impl;

import ac.za.cput.entity.user.Login;
import ac.za.cput.repository.user.LoginRepository;

import java.util.HashSet;
import java.util.Set;

public class LoginRepositoryImpl implements LoginRepository<Login, String> {
    private Set<Login> loginDB;

    public LoginRepositoryImpl() {
        this.loginDB = new HashSet<>();
    }


    @Override
    public Login create(Login login) {
        this.loginDB.add(login);
        return login;
    }

    @Override
    public Login read(String loginId) {
        Login login = this.loginDB.stream().filter(l -> l.getLoginId().equalsIgnoreCase(loginId))
                          .findAny()
                          .orElse(null);
        return login;
    }

    @Override
    public Login update(Login login) {
        Login oldlogin =read(login.getLoginId());
        if(oldlogin != null){
            this.loginDB.remove(login);
            this.loginDB.add(login);
        }
        return login;
    }

    @Override
    public void delete(String loginId) {
        Login login = read(loginId);
        if (login != null) this.loginDB.remove(login);
    }

    @Override
    public Set<Login> getAll() {
        return this.loginDB;
    }
}
