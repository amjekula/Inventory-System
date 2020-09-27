package ac.za.cput.controller.equipment;

import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.entity.equipment.FurnitureType;
import ac.za.cput.factory.equipment.DeviceTypeFactory;
import ac.za.cput.factory.equipment.FurnitureTypeFactory;
import ac.za.cput.service.equipment.impl.DeviceTypeServiceImpl;
import ac.za.cput.service.equipment.impl.FurnitureTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//JodiSmit
import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FurnitureTypeControllerTest {

    private static FurnitureType furnitureType = FurnitureTypeFactory.createFurnitureType("CupBoard", 5, "black");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/furnitureType/";



    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println(url);
        ResponseEntity<FurnitureType> postResponse = restTemplate.postForEntity(url, furnitureType, FurnitureType.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        furnitureType = postResponse.getBody();
        assertEquals(furnitureType.getFurnitureTypeId(), postResponse.getBody().getFurnitureTypeId());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read(){
        String url = baseURL + "read/" + furnitureType.getFurnitureTypeId();
        System.out.println(url);
        ResponseEntity<FurnitureType> responseEntity = restTemplate.getForEntity(url, FurnitureType.class);
        assertEquals(furnitureType.getFurnitureTypeId(), responseEntity.getBody().getFurnitureTypeId());
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void c_getAll() {

        String url = baseURL + "all";
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity.getBody());
    }

}