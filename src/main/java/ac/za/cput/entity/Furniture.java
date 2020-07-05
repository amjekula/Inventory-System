package ac.za.cput.entity;

public class Furniture {
    private String furnitureId;
    private String furnitureTypeId;


    //getters
    public String getFurnitureId() {
        return furnitureId;
    }



    public String getFurnitureTypeId() {
        return furnitureTypeId;
    }




    public Furniture(Builder builder) {

        this.furnitureId = builder.furnitureId;
        this.furnitureTypeId = builder.furnitureTypeId;
    }





    public static class Builder{
        private String furnitureId;
        private String furnitureTypeId;

        // setters
        public Builder setFurnitureId(String furnitureId) {
            this.furnitureId = furnitureId;
            return this;
        }



        public Builder setFurnitureTypeId(String furnitureTypeId) {
            this.furnitureTypeId = furnitureTypeId;
            return this;

        }





        public Builder copy (Furniture furniture){
            this.furnitureId = furniture.furnitureId;
            this.furnitureTypeId = furniture.furnitureTypeId;
            return this;
        }
        public Furniture build () {
            return new Furniture(this);

        }




        @Override
        public String toString() {
            return "Furniture{" +
                    "FurnitureId=" + furnitureId +
                    ", FurnitureTypeId=" + furnitureTypeId + "}";

        }

    }//Our Builder



} // Main
