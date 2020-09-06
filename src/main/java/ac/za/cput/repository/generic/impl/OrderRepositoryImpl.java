package ac.za.cput.repository.generic.impl;

import ac.za.cput.entity.generic.Order;
import ac.za.cput.repository.generic.OrderRepository;

import java.util.HashSet;
import java.util.Set;

public class OrderRepositoryImpl implements OrderRepository
{
    private static OrderRepository repository = null;
    private Set<Order> orderDB;

    public OrderRepositoryImpl()
    {
        this.orderDB = new HashSet<>();
    }

    public static OrderRepository getOrderRepository()
    {
        if(repository == null) repository = new OrderRepositoryImpl();
        return repository;
    }

    @Override
    public Order create(Order order)
    {
        this.orderDB.add(order);
        return order;
    }

    @Override
    public Order read(String stockId)
    {
        Order order = this.orderDB.stream().filter(l -> l.getStockId().equalsIgnoreCase(stockId))
                .findAny()
                .orElse(null);
        return order;
    }

    @Override
    public Order update(Order order)
    {
        Order oldorder =read(order.getStockId());
        if(oldorder != null)
        {
            this.orderDB.remove(oldorder);
            this.orderDB.add(order);
        }
        return order;
    }

    @Override
    public void delete(String stockId)
    {
        Order order = read(stockId);
        if (order != null) this.orderDB.remove(order);
    }

    @Override
    public Set<Order> getAll()
    {
        return this.orderDB;
    }
}

