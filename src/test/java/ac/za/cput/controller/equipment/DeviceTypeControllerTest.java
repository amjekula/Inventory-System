package ac.za.cput.controller.equipment;
//JodiSmit
import static org.junit.Assert.*;

import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.factory.equipment.DeviceTypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeviceTypeControllerTest {

    private static DeviceType deviceType = DeviceTypeFactory.createDeviceType("Printer", 5, "black");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/deviceType/";


    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println(url);
        ResponseEntity<DeviceType> postResponse = restTemplate.postForEntity(url, deviceType, DeviceType.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        deviceType = postResponse.getBody();
        assertEquals(deviceType.getDeviceTypeId(), postResponse.getBody().getDeviceTypeId());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read(){
        String url = baseURL + "read/" + deviceType.getDeviceTypeId();
        System.out.println(url);
        ResponseEntity<DeviceType> responseEntity = restTemplate.getForEntity(url, DeviceType.class);
        assertEquals(deviceType.getDeviceTypeId(), responseEntity.getBody().getDeviceTypeId());
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