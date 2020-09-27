package ac.za.cput.controller.generic;

import ac.za.cput.entity.generic.University;
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
    private String baseURL = "http://localhost:8080/university";

    @Test
    public void a_create() {
        University university = UniversityFactory.createUniversity("CPUT","123 Street");
        String url = baseURL + "/create";
        System.out.println(url);
        ResponseEntity<University> postResponse = restTemplate.postForEntity(url, university,University.class);
        assertNotNull(postResponse);

        System.out.println(postResponse);
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "/all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,String.class);
        System.out.println(response);
    }

    @Test
    public void b_read(){
        University university = UniversityFactory.createUniversity("CPUT","123 Street");
        String url = baseURL + "/read/" + university.getUniversityId();
        System.out.println(url);
        ResponseEntity<University> responseEntity = restTemplate.getForEntity(url, University.class);
        assertEquals(university.getUniversityId(), responseEntity.getBody().getUniversityId());
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void c_update(){
        University university = UniversityFactory.createUniversity("CPUT","123 Street");

        University updated = new University.Builder().copy(university).setName("UWC").setAddress("321 Seven Street").build();
        String url = baseURL + "/update";
        ResponseEntity<University> postResponse = restTemplate.postForEntity(url, updated, University.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(university.getUniversityId(), postResponse.getBody().getUniversityId());
        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
    }

    @Test
    public void e_delete(){
        University university = UniversityFactory.createUniversity("CPUT","123 Street");
        String url = baseURL + "/delete/" + university.getUniversityId();
        System.out.println("URL: " + url);
        ResponseEntity updateResponse = restTemplate.exchange(url, HttpMethod.DELETE, null, boolean.class);
        assertEquals(updateResponse.getStatusCode(), HttpStatus.OK);
    }
}