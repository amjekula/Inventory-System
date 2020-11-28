package ac.za.cput.service.generic.impl;
import ac.za.cput.entity.equipment.Device;
import ac.za.cput.entity.generic.Order;
import ac.za.cput.repository.generic.OrderRepository;
import ac.za.cput.service.generic.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService
{
    @Autowired
    private  OrderRepository repository;

    @Override
    public Set<Order> getAll()
    {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Order create(Order order)
    {
        return this.repository.save(order);
    }

    @Override
    public Order read(String s)
    {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Order update(Order order)
    {
        if (this.repository.existsById(order.getOrderNum()))
        {
            return create(order);
        }
        return null;
    }

    @Override
    public void delete(String s)
    {
        this.repository.deleteById(s);
    }
}
