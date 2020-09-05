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
public class OrderRepositoryImplTest {
    private static OrderRepository repository = new OrderRepositoryImpl();
    private static Order order = OrderFactory.createStockOrder("test", "21/07/2020");
    Set<Order> orders = repository.getAll();
    @Test
    public void a_create()
    {
        Order created =  repository.create(order);
        assertEquals(order.getStockId(), created.getStockId());
        System.out.print("created order: " + " " + created + "\n");
        System.out.print("\n");
    }

    @Test
    public void b_read()
    {
        Order read =  repository.read(order.getStockId());
        assertEquals(order.getStockId(), read.getStockId());
        System.out.print("reading order: " + " " +read);
        System.out.print("\n");
    }

    @Test
    public void c_update()
    {
        Order updated = new Order.Builder().copy(order).setDescription("test2").setOrderNum("123456").build();
        updated =  repository.update(updated);
        assertEquals(order.getStockId(), updated.getStockId());
        assertNotEquals(order.getDescription(), updated.getDescription());
        assertNotEquals(order.getOrderNum(), updated.getOrderNum());
        System.out.print("\n"+" updated order:" + " " + updated +"\n");

    }

    @Test
    public void e_delete()
    {


        repository.delete(order.getStockId());

        assertEquals(0, repository.getAll().size());
        System.out.print("\n" + "id removed:" + "  " + order.getStockId() + "\n");

        System.out.print("\n" + repository.getAll());

    }
    @Test
    public void d_getAll()
    {

        assertEquals(1, orders.size());
        System.out.print("all order details:" + "  " +repository.getAll()+"\n");

    }
}