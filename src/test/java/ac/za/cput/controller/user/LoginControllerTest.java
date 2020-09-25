package ac.za.cput.controller.user;

import ac.za.cput.entity.user.Login;
import ac.za.cput.factory.user.LoginFactory;
import ac.za.cput.repository.user.LoginRepository;
import ac.za.cput.repository.user.impl.LoginRepositoryImpl;
import ac.za.cput.service.user.LoginService;
import ac.za.cput.service.user.impl.LoginServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginControllerTest {

   private static Login login = LoginFactory.createLogin("josy@gmail.com", 25468);


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/login/";

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println(url);
        ResponseEntity<Login> postResponse = restTemplate.postForEntity(url, login, Login.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        login = postResponse.getBody();
        assertEquals(login.getLoginId(), postResponse.getBody().getLoginId());
        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read(){
        String url = baseURL + "read/" + login.getLoginId();
        System.out.println(url);
        ResponseEntity<Login> responseEntity = restTemplate.getForEntity(url, Login.class);
        assertEquals(login.getLoginId(), responseEntity.getBody().getLoginId());
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void c_update(){
        Login updated = new Login.Builder().copy(login).setEmailAddress("joselledina@gmail.com").setPassword(204785).build();
        String url = baseURL + "update";
        System.out.println(url);
        ResponseEntity<Login> postResponse = restTemplate.postForEntity(url, updated, Login.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(login.getLoginId(), postResponse.getBody().getLoginId());
        System.out.println(postResponse);
        System.out.println(postResponse.getBody());

    }

    @Test
    public void d_getAll() {

        String url = baseURL + "all";
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void e_delete(){
        String url = baseURL + "delete/"+ login.getLoginId();
        System.out.println(url);
        ResponseEntity<Login> responseEntity = restTemplate.getForEntity(url, Login.class);
        assertNull(login.getLoginId(), responseEntity.getBody().getLoginId());
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
        restTemplate.delete(url);


    }


}