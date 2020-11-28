package ac.za.cput.factory.generic;

import ac.za.cput.entity.generic.Order;

import ac.za.cput.util.GenericHelper;

/*
 *  @author: Lance Johnson
 *  Desc: Factory for Order Factory
 */

public class OrderFactory
{
    public static Order createClerkOrder(String clerkId, String stockId, String description, String date)
    {

        //primary key generation
        String orderNum = GenericHelper.generateId();
        Order order = new Order.Builder()
                .setClerkId(clerkId)
                .setStockId(stockId)
                .setOrderNum(orderNum)
                .setDescription(description)
                .setDate(date)
                .build();
        return order;

    }

}
