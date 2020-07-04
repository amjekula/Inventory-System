package ac.za.cput.factory;

import ac.za.cput.entity.Stock;
import org.junit.Test;

/*
 *  @author: Sherwin Adams
 *  Desc: Tests for Stock Factory
 */

public class StockFactoryTest {

    @Test
    public void createStock() {
        Stock stock = StockFactory.createStock(20, "02-06-2020");
        System.out.println(stock);
    }
}