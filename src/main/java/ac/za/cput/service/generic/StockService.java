package ac.za.cput.service.generic;

import ac.za.cput.entity.generic.Stock;
import ac.za.cput.service.IService;

import java.util.Set;

public interface StockService extends IService<Stock, String> {
    Set<Stock> getAll();
}
