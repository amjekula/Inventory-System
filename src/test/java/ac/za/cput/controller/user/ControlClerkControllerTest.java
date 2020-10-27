package ac.za.cput.controller.user;
/*
 *@author @amjekula
 * Description: Test Case for Control Clerk Controller
 * Date: 27 September 2020
 */
import ac.za.cput.entity.generic.University;
import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.factory.user.ControlClerkFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
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
public class ControlClerkControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/controlclerk/";
    private static ControlClerk controlClerk = ControlClerkFactory.createControlClerk("Mjekula",
            "Athenkosi", "0786682285", "athi@gmail.com", "1234556");

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        ResponseEntity<ControlClerk> postResponse = restTemplate.postForEntity(url, controlClerk, ControlClerk.class);

        controlClerk = postResponse.getBody();
        assertEquals(controlClerk.getFirstName(), postResponse.getBody().getFirstName());
        System.out.println(postResponse.getBody());

    }

    @Test
    public void b_read() {
        System.out.println("Read");
        String url = baseURL + "read/" + controlClerk.getClerkId();
        System.out.println("URL: " + url);
        ResponseEntity<ControlClerk> getResponse = restTemplate.getForEntity(url, ControlClerk.class);

        assertEquals(controlClerk.getClerkId(), getResponse.getBody().getClerkId());
        System.out.println(getResponse.getBody());
    }

    @Test
    public void c_update() {
        System.out.println("Update");
        controlClerk = new ControlClerk.ControlClerkBuilder().copy(controlClerk).
                setEmailAddress("athenkosi.mjeks@gmail.com").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        ResponseEntity<ControlClerk> postResponse = restTemplate.postForEntity(url, controlClerk, ControlClerk.class);

        assertEquals("athenkosi.mjeks@gmail.com", postResponse.getBody().getEmailAddress());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void e_delete() {
        System.out.println("Delete");
        String url = baseURL + "delete/" + controlClerk.getClerkId();
        System.out.println("URL: " + url);
        ResponseEntity<ControlClerk> deleteResponse = restTemplate.getForEntity(url, ControlClerk.class);
        restTemplate.delete(url);

        assertNull(controlClerk.getClerkId(), deleteResponse.getBody().getClerkId());
        System.out.println(deleteResponse.getBody());
    }

    @Test
    public void d_getAll() {
        System.out.println("Get All");
        String url = baseURL + "all";
        System.out.println("URL: " + url);

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        assertNotNull(response);
        System.out.println(response.getBody());
    }
}