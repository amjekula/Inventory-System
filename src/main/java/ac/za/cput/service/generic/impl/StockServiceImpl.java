package ac.za.cput.service.generic.impl;

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.entity.generic.Stock;
import ac.za.cput.repository.generic.StockRepository;
import ac.za.cput.service.generic.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/*
 *  @author: Sherwin Adams (216177499)
 *  Desc: Implementation for Stock Service
 */

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository repository;

    @Override
    public Set<Stock> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Stock create(Stock stock) {
        return  this.repository.save(stock);
    }

    @Override
    public Stock read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Stock update(Stock stock) {
        if (this.repository.existsById(stock.getStockId())) {
            return create(stock);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }
}
