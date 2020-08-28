package ac.za.cput.repository.user.impl;

import ac.za.cput.entity.user.Login;
import ac.za.cput.factory.user.LoginFactory;
import ac.za.cput.repository.user.LoginRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginRepositoryImplTest {
    private static LoginRepository repository = new LoginRepositoryImpl();
    private static Login login = LoginFactory.createLogin("joselle@gmail.com", 20202021);
    @Test
    public void a_create() {
        Login created = repository.create(login);
        assertEquals(login.getLoginId(), created.getLoginId());
        System.out.print(" Created Login Detail:" + " " + created);
        System.out.print("\n");
    }

    @Test
    public void b_read() {
        Login read = repository.read(login.getLoginId());
        assertEquals(login.getLoginId(), read.getLoginId());
        System.out.print(" Reading Login Detail:" + " " +read);
        System.out.print("\n");
    }

    @Test
    public void c_update() {
        Login updated = new Login.Builder().copy(login).setEmailAddress("joselledina@gmail.com").setPassword(204785).build();
        updated = repository.update(updated);
        assertEquals(login.getLoginId(), updated.getLoginId());
        assertNotEquals(login.getEmailAddress(), updated.getEmailAddress());
        assertNotEquals(login.getPassword(), updated.getPassword());
        System.out.print("\n"+" Updated Login Detail:" + " " + updated +"\n");

    }

    @Test
    public void e_delete() {
        repository.delete(login.getLoginId());
        System.out.print("\n");

    }

    @Test
    public void d_getAll() {
        Set<Login> logins = repository.getAll();
        assertEquals(1, logins.size());
        System.out.print("All login details:" + "  " +repository.getAll()+"\n");

    }
}