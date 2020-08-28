package ac.za.cput.entity.equipment;

public class Furniture {
    private String furnitureId;
    private String furnitureTypeId;





    public Furniture(Builder builder){
        this.furnitureId = builder.furnitureId;
        this.furnitureTypeId = builder.furnitureTypeId;
    }

    public static class Builder {
        private String furnitureId;
        private String furnitureTypeId;


        public Builder setFurnitureId(String furnitureId) {
            this.furnitureId = furnitureId;
            return this;
        }// Setter

        public Builder setFurnitureTypeId(String furnitureTypeId) {
            this.furnitureTypeId = furnitureTypeId;
            return this;
        } // Setter

        public Builder copy(Furniture furniture) {
            this.furnitureId = furniture.furnitureId;
            this.furnitureTypeId = furniture.furnitureTypeId;
            return this;
        }

        public Furniture build() {
            return new Furniture(this);

        }
    }
    public String getFurnitureId() {
        return furnitureId;
    }

    public String getFurnitureTypeId() {
        return furnitureTypeId;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "furnitureId=" + furnitureId +
                ", furnitureTypeId=" + furnitureTypeId +
                '}';
    }





} // Main
