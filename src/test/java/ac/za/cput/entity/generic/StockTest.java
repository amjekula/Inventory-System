package ac.za.cput.entity.generic;

import ac.za.cput.entity.generic.Stock;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 *  @author: Sherwin Adams
 *  Desc: Tests for Stock Entity
 */

public class StockTest {

    // Order 10 tables on 27 June 2020
    Stock table = new Stock.Builder().setStockId("1").setFurnitureId("1001").setQuantity(10).setDate("27-06-2020").build();

    // Order 5 computers on 30 May 2021
    Stock computer = new Stock.Builder().setStockId("2").setDeviceId("2001").setQuantity(5).setDate("30-05-2021").build();

    @Test
    public void getStockId() {
        assertEquals("1",table.getStockId());
        assertEquals("2",computer.getStockId());
    }

    @Test
    public void getFurnitureId()
    {
        assertEquals("1001",table.getFurnitureId());
    }

    @Test
    public void getDeviceId()
    {
        assertEquals("2001",computer.getDeviceId());
    }

    @Test
    public void getQuantity()
    {
        assertEquals(10,table.getQuantity());
        assertEquals(5,computer.getQuantity());
    }

    @Test
    public void getDate()
    {
        assertEquals("27-06-2020",table.getDate());
        assertEquals("30-05-2021",computer.getDate());
    }
}