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
        Order clerkOrder = OrderFactory.createClerkOrder("lance", "123", "test", "26/11/2020");
        System.out.println(clerkOrder);
    }

}