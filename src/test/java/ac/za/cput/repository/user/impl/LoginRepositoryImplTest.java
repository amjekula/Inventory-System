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
    private static LoginRepository repository = new LoginRepositoryImpl().getLoginRepository();
    private static Login login = LoginFactory.createLogin("joselle@gmail.com", 20202021);
    Set<Login> logins = repository.getAll();
    @Test
    public void a_create() {
        Login created = repository.create(login);
        assertEquals(login.getLoginId(), created.getLoginId());
        System.out.print(" Created Login Detail:" + " " + created + "\n");
        System.out.print("\n");
    }

    @Test
    public void b_read() {
        Login read =  repository.read(login.getLoginId());
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

        assertEquals(0, repository.getAll().size());
        System.out.print("\n" + "Removed Id:" + "  " + login.getLoginId() + "\n");

        System.out.print("\n" + repository.getAll());

    }

    @Test
    public void d_getAll() {

        assertEquals(1, logins.size());
        System.out.print("All login details:" + "  " +repository.getAll()+"\n");

    }
}