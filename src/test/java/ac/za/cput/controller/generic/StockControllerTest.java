package ac.za.cput.controller.generic;

import ac.za.cput.entity.generic.Stock;
import ac.za.cput.factory.generic.StockFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/*
 *  @author: Sherwin Adams
 *  Desc: Test of Stock controller
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StockControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/stock";

    Stock stock = StockFactory.createStock(10,"20 june 2020");


    @Test
    public void a_create() {
        String url = baseURL + "/create";
        System.out.println(url);
        ResponseEntity<Stock> postResponse = restTemplate.postForEntity(url, stock , Stock.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        stock = postResponse.getBody();
        assertEquals(stock.getStockId(), postResponse.getBody().getStockId());
        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
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
        String url = baseURL + "/read/" + stock.getStockId();
        System.out.println(url);
        ResponseEntity<Stock> responseEntity = restTemplate.getForEntity(url, Stock.class);
        assertEquals(stock.getStockId(), responseEntity.getBody().getStockId());
        System.out.println(responseEntity.getBody());
    }

    @Test
    public void c_update(){
        Stock updated = new Stock.Builder().copy(stock).setQuantity(200).setDate("15 July 2020").build();
        String url = baseURL + "/update";
        ResponseEntity<Stock> postResponse = restTemplate.postForEntity(url, updated, Stock.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(stock.getStockId(), postResponse.getBody().getStockId());
        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
    }

    @Test
    public void e_delete(){
        String url = baseURL + "/delete/" + stock.getStockId();
        System.out.println("URL: " + url);
        ResponseEntity updateResponse = restTemplate.exchange(url, HttpMethod.DELETE, null, boolean.class);
        assertEquals(updateResponse.getStatusCode(), HttpStatus.OK);
    }
}