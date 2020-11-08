package ac.za.cput.controller.generic;

import ac.za.cput.entity.generic.Order;
import ac.za.cput.factory.generic.OrderFactory;
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

public class OrderControllerTest
{

    private static Order order = OrderFactory.createClerkOrder("test", "25/09/2020");
    private static String SECURITY_USERNAME="admin";
    private static String SECURITY_PASSWORD="1234";


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/inventory/order/";

    @Test
    public void a_create()
    {
        String url = baseURL + "create";
        System.out.println(url);

        ResponseEntity<Order> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, order, Order.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        order = postResponse.getBody();
        assertNotEquals(order.getDescription(), postResponse.getBody().getDate());
        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read()
    {
        String url = baseURL + "read/" + order.getDescription();
        System.out.println(url);
        ResponseEntity<Order> responseEntity = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, Order.class);
        assertNotEquals(order.getDescription(), responseEntity.getBody().getDate());
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void c_update(){
        Order updated = new Order.Builder().copy(order).setDescription("test2").setDate("26/09/2020").build();
        String url = baseURL + "update";
        System.out.println(url);
        ResponseEntity<Order> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(url, updated, Order.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertNotEquals(order.getClerkId(), postResponse.getBody().getClerkId());
        System.out.println(postResponse);
        System.out.println(postResponse.getBody());

    }

    @Test
    public void d_getAll()
    {

        String url = baseURL + "all";
        System.out.println(url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void e_delete()
    {
        String url = baseURL + "delete/"+ order.getClerkId();
        System.out.println(url);
        ResponseEntity<Order> responseEntity = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url, Order.class);
        assertNull(order.getClerkId(), responseEntity.getBody().getClerkId());
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
        restTemplate.delete(url);


    }


}