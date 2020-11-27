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
        Order newOrder = OrderFactory.createClerkOrder(order.getClerkId(), order.getStockId(), order.getDescription(), order.getDate());
        return orderService.create(newOrder);

    }

    @GetMapping("/all")
    public Set<Order> getAll()
    {
        return orderService.getAll();
    }

    @DeleteMapping("/delete/{orderNum}")
    public void delete(@PathVariable String orderNum)
    {
        orderService.delete(orderNum);
    }

    @PostMapping("/update")
    public Order update(@RequestBody Order order)
    {
        return orderService.update(order);
    }

    @GetMapping("/read/{orderNum}")
    public Order read(@PathVariable String orderNum)
    {
        return orderService.read(orderNum);
    }


}
