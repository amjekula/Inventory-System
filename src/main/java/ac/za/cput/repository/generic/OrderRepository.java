package ac.za.cput.repository.generic;

import ac.za.cput.entity.generic.Order;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface OrderRepository extends IRepository<Order,String>
{
    Set<Order> getAll();
}
