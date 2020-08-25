package ac.za.cput.factory.generic;

import ac.za.cput.entity.generic.Order;
import ac.za.cput.factory.generic.OrderFactory;
import org.junit.Test;
/*
 *  @author: Lance Johnson
 *  Desc: Tests for Order Factory
 */

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