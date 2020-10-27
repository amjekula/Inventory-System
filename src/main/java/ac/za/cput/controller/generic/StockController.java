package ac.za.cput.controller.generic;

import ac.za.cput.entity.generic.Stock;
import ac.za.cput.factory.generic.StockFactory;
import ac.za.cput.service.generic.impl.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/*
 *  @author: Sherwin Adams
 *  Desc: Controller for Stock
 */

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockServiceImpl stockService;

    @PostMapping("/create")
    public Stock create(@RequestBody Stock stock) {
        Stock newStock = StockFactory.createStock(stock.getQuantity(),stock.getDate());
        return stockService.create(newStock);
    }

    @GetMapping("/all")
    public Set<Stock> getAll() {
        return stockService.getAll();
    }

    @DeleteMapping("/delete/{stockId}")
    public void delete(@PathVariable String stockId)
    {
        stockService.delete(stockId);
    }

    @PostMapping("/update")
    public Stock update(@RequestBody Stock stock){
        return stockService.update(stock);
    }

    @GetMapping("/read/{stockId}")
    public Stock read(@PathVariable String stockId)
    {
        return stockService.read(stockId);
    }
}