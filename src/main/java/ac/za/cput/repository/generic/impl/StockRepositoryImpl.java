package ac.za.cput.repository.generic.impl;

import ac.za.cput.entity.generic.Stock;
import ac.za.cput.repository.generic.StockRepository;

import java.util.HashSet;
import java.util.Set;

/*
 *  @author: Sherwin Adams (216177499)
 *  Desc: Implementation for stock repository
 */

public class StockRepositoryImpl implements StockRepository {
    private static StockRepository repository = null;
    private Set<Stock> stockDB;

    private StockRepositoryImpl() {
        this.stockDB = new HashSet<>();
    }

    public static StockRepository getRepository() {
        if (repository == null) repository = new StockRepositoryImpl();
        return repository;
    }


    @Override
    public Set<Stock> getAll() {
        return this.stockDB;
    }

    @Override
    public Stock create(Stock stock) {
        this.stockDB.add(stock);
        return stock;
    }

    @Override
    public Stock read(String stockId) {
        Stock stock = this.stockDB
                .stream()
                .filter(l -> l.getStockId().equalsIgnoreCase(stockId))
                .findAny()
                .orElse(null);

        return stock;

    }

    @Override
    public Stock update(Stock stock) {
        Stock oldStock = read(stock.getStockId());
        if (oldStock != null) {
            this.stockDB.remove(oldStock);
            this.stockDB.add(stock);
        }

        return stock;
    }

    @Override
    public void delete(String stockId) {
        Stock stock = read(stockId);
        if (stock != null)
            this.stockDB.remove(stock);
    }
}
