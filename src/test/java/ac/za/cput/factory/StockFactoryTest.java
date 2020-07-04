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
        Stock furniture = StockFactory.createStock(20, "02-06-2020");
        System.out.println(furniture);
    }
}