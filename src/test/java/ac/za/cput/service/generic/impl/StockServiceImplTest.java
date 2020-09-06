package ac.za.cput.service.generic.impl;

import ac.za.cput.entity.generic.Stock;
import ac.za.cput.factory.generic.StockFactory;
import ac.za.cput.service.generic.StockService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.assertEquals;

/*
 *  @author: Sherwin Adams (216177499)
 *  Desc: Tests for stock service implementation
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StockServiceImplTest {
    private static StockService service = StockServiceImpl.getService();
    private static Stock stock = StockFactory.createStock(25, "12-08-2020");

    @Test
    public void d_getAll() {
        Set<Stock> stockSet = service.getAll();
        assertEquals(1,stockSet.size());
        System.out.println("All Universities: " + stockSet);
    }

    @Test
    public void a_create() {
        Stock created = service.create(stock);
        assertEquals(stock.getStockId(),created.getStockId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Stock read = service.read(stock.getStockId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Stock updated = new Stock.Builder().copy(stock).setQuantity(11).build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        service.delete(stock.getStockId());
        assertEquals(0,service.getAll().size());
        System.out.println("Deleted: " + stock.getStockId());
    }
}
