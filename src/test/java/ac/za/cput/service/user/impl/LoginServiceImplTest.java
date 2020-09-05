package ac.za.cput.service.user.impl;

import ac.za.cput.entity.user.Login;
import ac.za.cput.factory.user.LoginFactory;
import ac.za.cput.service.user.LoginService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
/*
 *@author @joselleDina
 * Description: Interface for Login Service
 * Date: 02 September 2020
 */

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginServiceImplTest {
    private static LoginService loginService = LoginServiceImpl.getService();
    private static Login loginBuilder = LoginFactory.createLogin("joselle@gmail.com", 45862);

    @Test
    public void d_getAll() {
        Set<Login> logindB = loginService.getAll();
        assertEquals(1, logindB.size());
        System.out.println("All Users: " + loginService.getAll() + "\n");
    }

    @Test
    public void a_create() {
        Login createlogin = loginService.create(loginBuilder);
        assertEquals(createlogin.getLoginId(), createlogin.getLoginId());
        System.out.println(" Created Login Detail: " + createlogin + "\n");
    }

    @Test
    public void b_read() {
        Login readlogin = loginService.read(loginBuilder.getLoginId());
        assertNotNull(readlogin);
        System.out.println("Reading Login Detail: " + readlogin + "\n");
    }

    @Test
    public void c_update() {
        Login updateLogin = new Login.Builder().copy(loginBuilder).setEmailAddress("JoselleDina@gmail.com").build();
        updateLogin = loginService.update(updateLogin);
        assertNotEquals(loginBuilder.getEmailAddress(), updateLogin.getEmailAddress());
        System.out.println("Updated Login Detail: " + updateLogin + "\n");
    }

    @Test
    public void e_delete() {
        loginService.delete(loginBuilder.getLoginId());
        assertEquals(loginService.getAll().size(), 0);
        System.out.print("\n" + "Removed Id:" + "  " + loginBuilder.getLoginId() + "\n");
        System.out.println("Check deletion: " + loginService.getAll());

    }
}