package ac.za.cput.controller.equipment;


import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.factory.equipment.FurnitureFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FurnitureControllerTest {

    private static Furniture furniture = FurnitureFactory.createFurniture("1234");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/deviceType/";


    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println(url);
        ResponseEntity<Furniture> postResponse = restTemplate.postForEntity(url, furniture, Furniture.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        furniture = postResponse.getBody();
        assertEquals(furniture.getFurnitureId(), postResponse.getBody().getFurnitureId());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read(){
        String url = baseURL + "read/" + furniture.getFurnitureId();
        System.out.println(url);
        ResponseEntity<Furniture> responseEntity = restTemplate.getForEntity(url, Furniture.class);
        assertEquals(furniture.getFurnitureId(), responseEntity.getBody().getFurnitureId());
        System.out.println(responseEntity.getBody());
    }



    @Test
    public void c_update(){
        Furniture updated = new Furniture.Builder().copy(furniture).setFurnitureId("12345").build();
        String url = baseURL + "update";
        System.out.println(url);
        ResponseEntity<Furniture> postResponse = restTemplate.postForEntity(url, updated, Furniture.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(furniture.getFurnitureId(), postResponse.getBody().getFurnitureId());
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
        System.out.println(responseEntity.getBody());
    }



    @Test
    public void e_delete(){
        String url = baseURL + "delete/"+ furniture.getFurnitureId();
        System.out.println(url);
        ResponseEntity<Furniture> responseEntity = restTemplate.getForEntity(url, Furniture.class);
        assertNull(furniture.getFurnitureId(), responseEntity.getBody().getFurnitureId());
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
        restTemplate.delete(url);


    }
    
    

}