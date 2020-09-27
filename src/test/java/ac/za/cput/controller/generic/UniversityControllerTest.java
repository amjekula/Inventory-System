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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
    private University university = UniversityFactory.createUniversity("CPUT","123 Street");

    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println(url);
        ResponseEntity<University> postResponse = restTemplate.postForEntity(url, university,University.class);
        assertNotNull(postResponse);

        System.out.println(postResponse);
    }

    @Test
    public void d_getAll() {
        String url = baseURL + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,String.class);
        System.out.println(response);
    }

    @Test
    public void b_read(){
        String url = baseURL + "read/" + university.getUniversityId();
        ResponseEntity<University> responseEntity = restTemplate.getForEntity(url, University.class);
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void c_update(){
        University updated = new University.Builder().copy(university).setName("UWC").setAddress("not here").build();
        String url = baseURL + "update";
        ResponseEntity<University> postResponse = restTemplate.postForEntity(url, updated, University.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(university.getUniversityId(), postResponse.getBody().getUniversityId());
        System.out.println(postResponse);

    }

    @Test
    public void e_delete(){
        String url = baseURL + "delete/"+ university.getUniversityId();
        System.out.println(url);
        ResponseEntity<University> responseEntity = restTemplate.getForEntity(url, University.class);
        assertNull(university.getUniversityId(), responseEntity.getBody().getUniversityId());
        System.out.println(responseEntity);
        restTemplate.delete(url);
    }
}