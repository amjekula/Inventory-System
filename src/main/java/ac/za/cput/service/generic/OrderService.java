package ac.za.cput.service.generic;


import ac.za.cput.entity.generic.Order;
import ac.za.cput.service.IService;

import java.util.Set;

public interface OrderService extends IService <Order, String>{
    Set<Order> getAll();
}
