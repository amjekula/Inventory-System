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
import ac.za.cput.entity.equipment.Device;
import ac.za.cput.factory.equipment.DeviceFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DeviceControllerTest {

    private static Device device = DeviceFactory.createDevice("1234");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/deviceType/";


    @Test
    public void a_create() {
        String url = baseURL + "create";
        System.out.println(url);
        ResponseEntity<Device> postResponse = restTemplate.postForEntity(url, device, Device.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        device = postResponse.getBody();
        assertEquals(device.getDeviceId(), postResponse.getBody().getDeviceId());
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read(){
        String url = baseURL + "read/" + device.getDeviceId();
        System.out.println(url);
        ResponseEntity<Device> responseEntity = restTemplate.getForEntity(url, Device.class);
        assertEquals(device.getDeviceId(), responseEntity.getBody().getDeviceId());
        System.out.println(responseEntity.getBody());
    }



    @Test
    public void c_update(){
        Device updated = new Device.Builder().copy(device).setDeviceId("12345").build();
        String url = baseURL + "update";
        System.out.println(url);
        ResponseEntity<Device> postResponse = restTemplate.postForEntity(url, updated, Device.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(device.getDeviceId(), postResponse.getBody().getDeviceId());
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
        String url = baseURL + "delete/"+ device.getDeviceId();
        System.out.println(url);
        ResponseEntity<Device> responseEntity = restTemplate.getForEntity(url, Device.class);
        assertNull(device.getDeviceId(), responseEntity.getBody().getDeviceId());
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
        restTemplate.delete(url);


    }







}