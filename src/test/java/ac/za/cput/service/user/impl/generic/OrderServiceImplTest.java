package ac.za.cput.service.user.impl.generic;


import ac.za.cput.entity.generic.Order;
import ac.za.cput.factory.generic.OrderFactory;
import ac.za.cput.repository.generic.OrderRepository;
import ac.za.cput.repository.generic.impl.OrderRepositoryImpl;
import ac.za.cput.service.generic.OrderService;
import ac.za.cput.service.generic.impl.OrderServiceImpl;
import javafx.scene.effect.SepiaTone;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderServiceImplTest {
    private static OrderService orderService = OrderServiceImpl.getService();
    private static Order orderBuilder = OrderFactory.createClerkOrder("test", "9/04/2020");


    public void a_create()
    {
        Order created = orderService.create(orderBuilder);
        assertEquals(orderBuilder.getStockId(), created.getStockId());
        System.out.print("created order: " + " " + created + "\n");
        System.out.print("\n");
    }

    @Test
    public void b_read()
    {
        Order read = orderService.read(orderBuilder.getStockId());
        assertEquals(orderBuilder.getStockId(), read.getStockId());
        System.out.print("reading order: " + " " + read);
        System.out.print("\n");
    }

    @Test
    public void c_update()
    {
        Order updated = new Order.Builder().copy(orderBuilder).setDescription("test2").setOrderNum("123456").build();
        updated = orderService.update(updated);
        assertEquals(orderBuilder.getStockId(), updated.getStockId());
        assertNotEquals(orderBuilder.getDescription(), updated.getDescription());
        assertNotEquals(orderBuilder.getOrderNum(), updated.getOrderNum());
        System.out.print("\n"+" updated order:" + " " + updated +"\n");

    }

    @Test
    public void e_delete()
    {
        orderService.delete(orderBuilder.getStockId());
        assertEquals(0, orderService.getAll().size());
        System.out.print("\n" + "id removed:" + "  " + orderBuilder.getStockId() + "\n");
        System.out.print("\n" + orderService.getAll());
    }
    @Test
    public void d_getAll()
    {
        orderService.delete(orderBuilder.getClerkId());
        assertEquals(orderService.getAll().size(), 0);
        System.out.println("Check if Object is deleted: " + orderService.getAll());
    }
}
