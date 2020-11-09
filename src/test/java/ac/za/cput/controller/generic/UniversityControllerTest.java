package ac.za.cput.controller.generic;

import ac.za.cput.entity.generic.Stock;
import ac.za.cput.entity.generic.University;
import ac.za.cput.entity.user.Login;
import ac.za.cput.factory.generic.UniversityFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/*
 *  @author: Sherwin Adams
 *  Desc: Test of University controller
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UniversityControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/university/";
    private static University university = UniversityFactory.createUniversity("CPUT","123 Street");

    private static String SECURITY_USERNAME="admin";
    private static String SECURITY_PASSWORD="1234";

    @Test
    public void a_create() {
        System.out.println("Create");
        String url = baseURL + "create";
        System.out.println(url);
        ResponseEntity<University> postResponse = restTemplate.postForEntity(url, university, University.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        university = postResponse.getBody();
        assertEquals(university.getUniversityId(), postResponse.getBody().getUniversityId());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read(){
        System.out.println("Read");
        String url = baseURL + "read/" + university.getUniversityId();
        System.out.println(url);
        ResponseEntity<University> responseEntity = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .getForEntity(url, University.class);
        assertEquals(university.getUniversityId(), responseEntity.getBody().getUniversityId());
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void c_update(){
        System.out.println("Update");
        University updated = new University.Builder().copy(university).setName("UWC").setAddress("10 Link Road").build();
        String url = baseURL + "update";
        System.out.println(url);
        ResponseEntity<University> postResponse = restTemplate.postForEntity(url, updated, University.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(university.getUniversityId(), postResponse.getBody().getUniversityId());
        System.out.println(postResponse.getBody());

    }

    @Test
    public void d_getAll() {
        System.out.println("All");
        String url = baseURL + "all";
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void e_delete(){
        System.out.println("Delete");
        String url = baseURL + "delete/"+ university.getUniversityId();
        System.out.println(url);
        ResponseEntity<University> responseEntity = restTemplate.getForEntity(url, University.class);
        assertNull(university.getUniversityId(), responseEntity.getBody().getUniversityId());
        restTemplate.delete(url);
    }
}