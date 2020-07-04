package ac.za.cput.factory;

/*
 *  @author: Sherwin Adams
 *  Desc: Factory for Stock Factory
 */

import ac.za.cput.entity.Stock;
import ac.za.cput.util.GenericHelper;

public class StockFactory {
    public static Stock createFurnitureStock(int quantity, String date) {
        String stockId = GenericHelper.generateId();
        String furnitureStockId = GenericHelper.generateId();
        Stock furnitureStock = new Stock.Builder()
                .setStockId(stockId)
                .setFurnitureId(furnitureStockId)
                .setQuantity(quantity)
                .setDate(date)
                .build();
        return furnitureStock;
    }

    public static Stock createDeviceStock(int quantity, String date) {
        String stockId = GenericHelper.generateId();
        String deviceStockId = GenericHelper.generateId();
        Stock deviceStock = new Stock.Builder()
                .setStockId(stockId)
                .setDeviceId(deviceStockId)
                .setQuantity(quantity)
                .setDate(date)
                .build();
        return deviceStock;
    }

}
