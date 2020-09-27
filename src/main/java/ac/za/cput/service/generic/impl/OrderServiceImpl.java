package ac.za.cput.service.generic.impl;


import ac.za.cput.entity.generic.Order;
import ac.za.cput.repository.generic.OrderRepository;
import ac.za.cput.repository.generic.impl.OrderRepositoryImpl;
import ac.za.cput.service.generic.OrderService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OrderServiceImpl implements OrderService
{

    private static OrderService service = null;
    private OrderRepository repository;

    private OrderServiceImpl()
    {
        this.repository = OrderRepositoryImpl.getOrderRepository();
    }

    public static OrderService getService()
    {
        if(service == null)
        {
            service = new OrderServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Order> getAll()
    {
        return this.repository.getAll();
    }

    @Override
    public Order create(Order order)
    {
        return this.repository.create(order);
    }

    @Override
    public Order read(String StockId)
    {
        return this.repository.read(StockId);
    }

    @Override
    public Order update(Order order)
    {
        return this.repository.update(order);
    }

    @Override
    public void delete(String clerkId)
    {
        this.repository.delete(clerkId);
    }
}
