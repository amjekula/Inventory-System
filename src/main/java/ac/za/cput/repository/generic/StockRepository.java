package ac.za.cput.repository.generic;

import ac.za.cput.entity.generic.Stock;
import ac.za.cput.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/*
 *  @author: Sherwin Adams (216177499)
 *  Desc: Stock repository
 */

@Repository
public interface StockRepository extends JpaRepository<Stock,String> {
}
