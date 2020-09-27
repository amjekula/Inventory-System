package ac.za.cput.controller.user;
/*
 *@author @amjekula
 * Description: Test Case for Control Clerk Controller
 * Date: 27 September 2020
 */
import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.factory.user.ControlClerkFactory;
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
public class ControlClerkControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/controlclerk/";

    private static ControlClerk controlClerk = ControlClerkFactory.createControlClerk("Mjekula",
            "Athenkosi", "078 6682 258", "athi@gmail.com");

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        ResponseEntity<ControlClerk> postResponse = restTemplate.postForEntity(url, controlClerk, ControlClerk.class);
        controlClerk = postResponse.getBody();

        System.out.println(postResponse.getBody());
        assertEquals(controlClerk.getFirstName(), postResponse.getBody().getFirstName());
    }

    @Test
    public void b_read() {
        String url = baseURL + "read/" + controlClerk.getClerkId();
        System.out.println("URL: " + url);
        ResponseEntity<ControlClerk> getResponse = restTemplate.getForEntity(url, ControlClerk.class);

        System.out.println(getResponse.getBody());
        assertEquals(controlClerk.getClerkId(), getResponse.getBody().getClerkId());
    }

    @Test
    public void c_update() {
        controlClerk = new ControlClerk.ControlClerkBuilder().copy(controlClerk).
                setEmailAddress("athenkosi.mjeks@gmail.com").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        ResponseEntity<ControlClerk> postResponse = restTemplate.postForEntity(url, controlClerk, ControlClerk.class);

        System.out.println(postResponse.getBody());
        assertEquals("athenkosi.mjeks@gmail.com", postResponse.getBody().getEmailAddress());
    }

    @Test
    public void e_delete() {
        String url = baseURL + "delete/" + controlClerk.getClerkId();
        System.out.println("URL: " + url);
        ResponseEntity<ControlClerk> deleteResponse = restTemplate.getForEntity(url, ControlClerk.class);
        restTemplate.delete(url);

        assertNull(controlClerk.getClerkId(), deleteResponse.getBody().getClerkId());
        System.out.println(deleteResponse.getBody());
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        System.out.println("URL: " + url);

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response.getBody());
        assertNotNull(response);
    }
}