package ac.za.cput.entity.generic;

/*
 *  @author: Sherwin Adams
 *  Desc: Entity for Stock
 */

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.entity.equipment.Furniture;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Stock implements Serializable
{
    @Id
    private String stockId;
    private String furnitureId;
    private String deviceId;
    private int quantity;
    private String date;

    @OneToOne(mappedBy = "stock",cascade = CascadeType.ALL)
    private Device device;

    @OneToOne(mappedBy = "stock",cascade = CascadeType.ALL)
    private Furniture furniture;

    protected Stock(){}

    private Stock(Builder builder)
    {
        this.stockId = builder.stockId;
        this.furnitureId = builder.furnitureId;
        this.deviceId = builder.deviceId;
        this.quantity = builder.quantity;
        this.date = builder.date;
    }

    public String getStockId()
    {
        return stockId;
    }

    public String getFurnitureId()
    {
        return furnitureId;
    }

    public String getDeviceId() { return deviceId; }

    public int getQuantity()
    {
        return quantity;
    }

    public String getDate()
    {
        return date;
    }

    public static class Builder
    {
        private String stockId;
        private String furnitureId;
        private String deviceId;
        private int quantity;
        private String date;

        public Builder setStockId(final String stockId) {
            this.stockId = stockId;
            return this;
        }

        public Builder setFurnitureId(final String furnitureId) {
            this.furnitureId = furnitureId;
            return this;
        }

        public Builder setDeviceId(final String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        public Builder setQuantity(final int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setDate(final String date) {
            this.date = date;
            return this;
        }

        public Builder copy(Stock stock) {
            this.stockId = stock.stockId;
            this.deviceId = stock.deviceId;
            this.furnitureId = stock.furnitureId;
            this.quantity = stock.quantity;
            this.date = stock.date;
            return this;
        }

        public Stock build()
        {
            return new Stock(this);
        }
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", furnitureId=" + furnitureId +
                ", deviceId=" + deviceId +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return stockId.equals(stock.stockId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockId);
    }
}
