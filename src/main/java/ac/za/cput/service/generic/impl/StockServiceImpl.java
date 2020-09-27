package ac.za.cput.service.generic.impl;

import ac.za.cput.entity.generic.Stock;
import ac.za.cput.repository.generic.StockRepository;
import ac.za.cput.repository.generic.impl.StockRepositoryImpl;
import ac.za.cput.service.generic.StockService;
import org.springframework.stereotype.Service;

import java.util.Set;

/*
 *  @author: Sherwin Adams (216177499)
 *  Desc: Implementation for Stock Service
 */

@Service
public class StockServiceImpl implements StockService {

    private static StockService service = null;
    private StockRepository repository;

    private StockServiceImpl() { this.repository = StockRepositoryImpl.getRepository(); }

    public static StockService getService() {
        if (service == null) service = new StockServiceImpl();
        return service;
    }

    @Override
    public Set<Stock> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Stock create(Stock stock) {
        return  this.repository.create(stock);
    }

    @Override
    public Stock read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Stock update(Stock stock) {
        return this.repository.update(stock);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }
}
