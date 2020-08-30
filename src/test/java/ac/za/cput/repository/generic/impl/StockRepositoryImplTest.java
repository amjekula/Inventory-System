package ac.za.cput.repository.generic.impl;

import ac.za.cput.entity.generic.Stock;
import ac.za.cput.entity.generic.University;
import ac.za.cput.factory.generic.StockFactory;
import ac.za.cput.repository.generic.StockRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/*
 *  @author: Sherwin Adams (216177499)
 *  Desc: test implementation for stock repository
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StockRepositoryImplTest {

    private static StockRepository repository = StockRepositoryImpl.getRepository();
    private static Stock stock = StockFactory.createStock(10,"2020-8-28");

    @Test
    public void d_getAll() {
        System.out.println("Get All: " + repository.getAll());
    }


    @Test
    public void a_create() {
        Stock created = repository.create(stock);
        assertEquals(stock.getStockId(),created.getStockId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Stock read = repository.read(stock.getStockId());
        System.out.println("Read: "+read);
    }

    @Test
    public void c_update() {
        Stock updated = new Stock.Builder().copy(stock).setQuantity(200).build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete() {
        repository.delete(stock.getStockId());
        assertNotNull(stock);
        System.out.println("Deleted: " + stock);
        System.out.println(repository.getAll());
    }
}