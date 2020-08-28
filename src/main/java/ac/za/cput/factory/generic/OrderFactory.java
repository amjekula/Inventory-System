package ac.za.cput.factory.generic;

import ac.za.cput.entity.generic.Order;

import ac.za.cput.util.GenericHelper;

/*
 *  @author: Lance Johnson
 *  Desc: Factory for Order Factory
 */

public class OrderFactory
{
    public static Order createClerkOrder(String description, String date)
    {
        String clerkId = GenericHelper.generateId();
        String OrderOrderId = GenericHelper.generateId();
        Order order = new Order.Builder()
                .setClerkId(clerkId)
                .setOrderNum(OrderOrderId)
                .setDescription(description)
                .setDate(date)
                .build();
         return order;

    }


    public static Order createStockOrder(String description, String date)
    {
        String clerkId = GenericHelper.generateId();
        String stockOrderId = GenericHelper.generateId();
        Order stockOrder = new Order.Builder()
                .setClerkId(clerkId)
                .setStockId(stockOrderId)
                .setDescription(description)
                .setDate(date)
                .build();
         return stockOrder;

    }

}
