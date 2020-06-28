package ac.za.cput.entity;

public class Stock {
    private final int stockId;
    private final int furnitureId;
    private final int deviceId;
    private final int quantity;
    private final String date;

    private Stock(Builder builder) {
        this.stockId = builder.stockId;
        this.furnitureId = builder.furnitureId;
        this.deviceId = builder.deviceId;
        this.quantity = builder.quantity;
        this.date = builder.date;
    }

    public int getStockId() {
        return stockId;
    }

    public int getFurnitureId() {
        return furnitureId;
    }

    public int getDeviceId() { return deviceId; }

    public int getQuantity() {
        return quantity;
    }

    public String getDate() {
        return date;
    }

    public static class Builder {
        private int stockId;
        private int furnitureId;
        private int deviceId;
        private int quantity;
        private String date;

        public Builder setStockId(final int stockId) {
            this.stockId = stockId;
            return this;
        }

        public Builder setFurnitureId(final int furnitureId) {
            this.furnitureId = furnitureId;
            return this;
        }

        public Builder setDeviceId(final int deviceId) {
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

        public Stock build() {
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
}
