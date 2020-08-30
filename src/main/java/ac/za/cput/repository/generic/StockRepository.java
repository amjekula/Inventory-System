package ac.za.cput.repository.generic;

import ac.za.cput.entity.generic.Stock;
import ac.za.cput.repository.IRepository;

import java.util.Set;

/*
 *  @author: Sherwin Adams (216177499)
 *  Desc: Stock repository
 */

public interface StockRepository extends IRepository<Stock,String> {
    Set<Stock> getAll();
}
