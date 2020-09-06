package ac.za.cput.service.generic.impl;


import ac.za.cput.entity.generic.Order;
import ac.za.cput.factory.generic.OrderFactory;
import ac.za.cput.service.generic.OrderService;
import ac.za.cput.service.generic.impl.OrderServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderServiceImplTest
{
    private static OrderService orderService = OrderServiceImpl.getService();
    private static Order orderBuilder = OrderFactory.createStockOrder("test", "5/09/2020");

    @Test
    public void d_getAll()
    {
        Set<Order> orderSet = orderService.getAll();
        assertEquals(1, orderSet.size());
        System.out.println("All Users: " + orderService.getAll() + "\n");
    }

    @Test
    public void a_create()
    {
        Order createOrder = orderService.create(orderBuilder);
        assertEquals(createOrder.getDescription(), createOrder.getDescription());
        System.out.println("Create: " + createOrder + "\n");
    }

    @Test
    public void b_read()
    {
        Order readOrder = orderService.read(orderBuilder.getDescription());
        assertEquals(orderBuilder.getDescription(), orderBuilder.getDescription());
        System.out.println("Read: " + readOrder + "\n");
    }

    @Test
    public void c_update()
    {
        Order updateOrder = new Order.Builder().copy(orderBuilder).setDescription("test2").build();
        updateOrder = orderService.update(updateOrder);
        assertNotEquals(orderBuilder.getDescription(), updateOrder.getDescription());
        System.out.println("Update: " + updateOrder + "\n");
    }

    @Test
    public void e_delete()
    {
        orderService.delete(orderBuilder.getClerkId());
        assertEquals(orderService.getAll().size(), 1);
        System.out.println("Check if Object is deleted: " + orderService.getAll());
    }


}