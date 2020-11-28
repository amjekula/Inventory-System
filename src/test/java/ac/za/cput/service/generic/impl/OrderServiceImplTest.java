package ac.za.cput.service.generic.impl;
import ac.za.cput.entity.generic.Order;
import ac.za.cput.factory.generic.OrderFactory;
import ac.za.cput.service.generic.OrderService;
import ac.za.cput.service.generic.impl.OrderServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderServiceImplTest
{
    @Autowired
    private static OrderService orderService;
    private static Order orderBuilder = OrderFactory.createClerkOrder("lance", "123", "test", "26/11/2020");

    @Test
    public void d_getAll()
    {
        Set<Order> orderSet = orderService.getAll();
        assertEquals(1, orderSet.size());
        System.out.println("All Users: " + orderSet);
    }

    @Test
    public void a_create()
    {
        Order createOrder = orderService.create(orderBuilder);
        assertEquals(createOrder.getOrderNum(), createOrder.getOrderNum());
        System.out.println("Create: " + createOrder + "\n");
    }

    @Test
    public void b_read()
    {
        Order readOrder = orderService.read(orderBuilder.getOrderNum());
        System.out.println("Read: " + readOrder + "\n");
    }

    @Test
    public void c_update()
    {
        Order updateOrder = new Order.Builder().copy(orderBuilder).setDescription("test2").build();
        updateOrder = orderService.update(updateOrder);
        System.out.println("Update: " + updateOrder + "\n");
    }

    @Test
    public void e_delete()
    {
        orderService.delete(orderBuilder.getOrderNum());
        assertEquals(0,orderService.getAll().size());
        System.out.println("Check if Object is deleted: " + orderService.getAll());
    }


}