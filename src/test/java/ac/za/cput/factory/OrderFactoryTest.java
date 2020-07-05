package ac.za.cput.factory;

import ac.za.cput.entity.Order;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderFactoryTest
{
    @Test
    public void createClerkOrder()
    {
        Order clerkOrder = OrderFactory.createClerkOrder("5", "04-07-2020");
        System.out.println(clerkOrder);
    }

    @Test
    public void createStockOrder()
    {
        Order stockOrder = OrderFactory.createStockOrder("10", "04-07-2020"); 
        System.out.println(stockOrder);

    }

}