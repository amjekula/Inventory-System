package ac.za.cput.repository.generic;

import ac.za.cput.entity.generic.Order;
import ac.za.cput.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {



}