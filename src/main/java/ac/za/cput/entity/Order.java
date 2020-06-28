package ac.za.cput.entity;

public class Order
{
    private final int orderNum;
    private final int clerkId;
    private final int stockId;
    private final String description;
    private final String date;


    public Order(Builder builder)
    {
        this.orderNum = builder.orderNum;
        this.clerkId = builder.clerkId;
        this.stockId = builder.stockId;
        this.description = builder.description;
        this.date = builder.date;
    }


    public int getOrderNum()
    {
        return orderNum;
    }

    public int getClerkId()
    {
        return clerkId;
    }

    public int getStockId()
    {
        return stockId;
    }

    public String getDescription()
    {
        return description;
    }

    public String getDate()
    {
        return date;
    }


    public static class Builder
    {
        private int orderNum;
        private int clerkId;
        private int stockId;
        private String description;
        private String date;


        public Builder setOrderNum(final int orderNum)
        {
            this.orderNum = orderNum;
            return this;
        }

        public Builder setClerkId(final int clerkId)
        {
            this.clerkId = clerkId;
            return this;
        }

        public Builder setStockId( final int stockId)
        {
            this.stockId = stockId;
            return this;
        }

        public Builder setDescription(final String description)
        {
            this.description = description;
            return this;
        }

        public Builder setDate(final String date)
        {
            this.date = date;
            return this;
        }


        public Order build()
        {
            return new Order(this);
        }


    }


    @Override
    public String toString()
    {
        return "Stock{" +
                "orderNum=" + orderNum +
                ", clerkId=" + clerkId +
                ", stockId=" + stockId +
                ", description=" + description +
                ", date=" + date +
                '}';
    }
}
