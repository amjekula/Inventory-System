package ac.za.cput.entity.generic;

import ac.za.cput.entity.generic.Order;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest
{

    Order table = new Order.Builder().setOrderNum("5").setClerkId("10").setStockId("15").setDescription("test").setDate("26-06-2020").build();


    @Test
    public void getOrderNum()
    {
        assertEquals("5",table.getOrderNum());

    }

    @Test
    public void getClerkId()
    {
        assertEquals("10",table.getClerkId());
    }

    public void getStockId()
    {
        assertEquals("15",table.getStockId());

    }

    @Test
    public void getDescription()
    {
        assertEquals("test",table.getDate());
    }


    @Test
    public void getDate()
    {
        assertEquals("26-06-2020",table.getDate());

    }

}