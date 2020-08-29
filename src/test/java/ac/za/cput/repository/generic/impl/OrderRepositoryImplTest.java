package ac.za.cput.repository.generic.impl;

import ac.za.cput.entity.generic.Order;
import ac.za.cput.factory.generic.OrderFactory;
import ac.za.cput.repository.generic.OrderRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderRepositoryImplTest
{
    private static OrderRepository repository = new OrderRepositoryImpl();

    private static Order order = OrderFactory.createClerkOrder("test", "12345");
    private static Order order2 = OrderFactory.createClerkOrder("test", "12345");
    Set<Order> orders = repository.getAll();
    @Test
    public void a_create()
    {
        Order created = (Order)repository.create(order);
        assertEquals(order.getStockId(), created.getStockId());
        System.out.print(" Created Order Number:" + " " + created + "\n");
        System.out.print("\n");
    }

    @Test
    public void b_read()
    {
        Order read = (Order)repository.read(order.getStockId());
        assertNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    public void c_update()
    {
        Order updated = new Order.Builder().copy(order).setDescription("test3").setDate("123456").build();
        updated = (Order) repository.update(updated);
        assertEquals(order.getStockId(), updated.getStockId());
        assertNotEquals(order.getDescription(), updated.getDescription());
        assertNotEquals(order.getDate(), updated.getDate());
        System.out.print("\n"+" Updated Order Detail:" + " " + updated +"\n");
    }

    @Test
    public void e_delete()
    {
        repository.delete(order.getDescription());
        assertNotNull(order);
        System.out.print("\n" + "Removed Order Number:" + "  " + order.getDescription() + "\n");
        System.out.print("\n" + repository.getAll());
    }

    @Test
    public void d_getAll()
    {
        System.out.println("Get All: " + repository.getAll());
    }


}