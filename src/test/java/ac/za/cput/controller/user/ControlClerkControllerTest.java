package ac.za.cput.controller.user;
/*
 *@author @amjekula
 * Description: Test Case for Control Clerk Controller
 * Date: 27 September 2020
 */
import ac.za.cput.entity.generic.University;
import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.factory.generic.UniversityFactory;
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

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControlClerkControllerTest {

    //Admin Credentials
    private static String ADMIN_USERNAME="admin";
    private static String ADMIN_PASSWORD="1234";

    //Clerk Credentials
    private static String CLERK_USERNAME="clerk";
    private static String CLERK_PASSWORD="4567";

    private University university = UniversityFactory.createUniversity("University of South Africa", "12345678789");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/inventory/controlclerk/";
    private  ControlClerk controlClerk = ControlClerkFactory.createControlClerk(university, "Mjekula",
            "Athenkosi", "0786682285", "athi@gmail.com", "1234556",
            "6 Varsity Street", "Western Cape");

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println("URL: " + url);
        ResponseEntity<ControlClerk> postResponse = restTemplate
                .withBasicAuth(ADMIN_USERNAME, ADMIN_PASSWORD)
                .postForEntity(url, controlClerk, ControlClerk.class);

        System.out.println("Status Code: " + postResponse.getStatusCode());
        controlClerk = postResponse.getBody();
        System.out.println("Control Clerk: " + controlClerk);
        assertEquals(controlClerk.getFirstName(), postResponse.getBody().getFirstName());
    }

    @Test
    public void b_read() {
        System.out.println("Read");
        String url = baseURL + "read/" + controlClerk.getClerkId();
        System.out.println("URL: " + url);
        ResponseEntity<ControlClerk> getResponse = restTemplate
                .withBasicAuth(CLERK_USERNAME, CLERK_PASSWORD)
                .getForEntity(url, ControlClerk.class);

        System.out.println(getResponse);
        assertEquals(controlClerk.getClerkId(), getResponse.getBody().getClerkId());
    }

    @Test
    public void c_update() {
        System.out.println("Update");
        controlClerk = new ControlClerk.ControlClerkBuilder().copy(controlClerk).
                setEmailAddress("athenkosi.mjeks@gmail.com").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        ResponseEntity<ControlClerk> postResponse = restTemplate
                .withBasicAuth(CLERK_USERNAME, CLERK_PASSWORD)
                .postForEntity(url, controlClerk, ControlClerk.class);

        System.out.println(postResponse);
        assertEquals("athenkosi.mjeks@gmail.com", postResponse.getBody().getEmailAddress());
    }

    @Test
    @Ignore
    public void e_delete() {
        System.out.println("Delete");
        String url = baseURL + "delete/" + controlClerk.getClerkId();
        System.out.println("URL: " + url);
        ResponseEntity<ControlClerk> deleteResponse = restTemplate
                .withBasicAuth(ADMIN_USERNAME, ADMIN_PASSWORD)
                .getForEntity(url, ControlClerk.class);
        restTemplate.delete(url);

        System.out.println(deleteResponse);
        assertNull(controlClerk.getClerkId(), deleteResponse.getBody().getClerkId());
    }

    @Test
    public void d_getAll() {
        System.out.println("Get All");
        String url = baseURL + "all";
        System.out.println("URL: " + url);

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(CLERK_USERNAME, CLERK_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        assertNotNull(response);
    }
}