package ac.za.cput.controller.generic;

import ac.za.cput.entity.generic.Order;
import ac.za.cput.factory.generic.OrderFactory;
import ac.za.cput.service.generic.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/create")
    public Order create(@RequestBody Order order)
    {
        Order newOrder = OrderFactory.createClerkOrder(order.getDescription(), order.getDate());
        return orderService.create(newOrder);
    }

    @GetMapping("/all")
    public Set<Order> getAll()
    {
        return orderService.getAll();
    }

}
