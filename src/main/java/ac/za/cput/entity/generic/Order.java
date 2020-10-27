package ac.za.cput.entity.generic;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "`order`")
public class Order implements Serializable
{
    @Id
    private String orderNum;
    private String clerkId;
    private String stockId;
    private String description;
    private String date;


    protected Order(){}
    private Order(Builder builder)
    {
        this.orderNum = builder.orderNum;
        this.clerkId = builder.clerkId;
        this.stockId = builder.stockId;
        this.description = builder.description;
        this.date = builder.date;

    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return clerkId.equals(order.clerkId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(clerkId);
    }

    public static class Builder
    {
        private String orderNum;
        private String clerkId;
        private String stockId;
        private String description;
        private String date;

        public Builder setOrderNum(final String orderNum)
        {
            this.orderNum = orderNum;
            return this;
        }

        public Builder setClerkId(final String clerkId)
        {
            this.clerkId = clerkId;
            return this;
        }

        public Builder setStockId( final String stockId)
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

        public Builder copy(Order order)
        {
            this.orderNum = order.orderNum;
            this.clerkId = order.clerkId;
            this.stockId = order.stockId;
            this.description = order.description;
            this.date = order.date;
            return this;
        }

        public Order build()
        {
            return new Order(this);
        }

    }

    public String getOrderNum()
    {
        return orderNum;
    }

    public String getClerkId()
    {
        return clerkId;
    }

    public String getStockId()
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