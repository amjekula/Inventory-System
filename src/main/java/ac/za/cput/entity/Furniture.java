package ac.za.cput.entity;

public class Furniture //start of the class
{
    private String furnitureId, furnitureTypeId;

    //getters
    public String getFurnitureId() {
        return furnitureId;
    }

    public String getFurnitureTypeId() {
        return furnitureTypeId;
    }


    public Furniture(Builder builder){ //this is the builder constructor

        this.furnitureId = builder.furnitureId;
        this.furnitureTypeId = builder.furnitureTypeId;

    }

    public static class Builder{ // the builder class start here now
        private String furnitureId;
        private String furnitureTypeId;

        //setters

        public Builder setFurnitureId(String furnitureId){
            this.furnitureId = furnitureId;
            return this;
        }

        public Builder setFurnitureTypeId(String furnitureTypeId){
            this.furnitureTypeId = furnitureTypeId;
            return this;
        }

        public Furniture.Builder copy (Furniture furniture){
            this.furnitureId= furniture.furnitureId;
            this.furnitureTypeId= furniture.furnitureTypeId;
            return this;
        }


        public Furniture build(){
            return new Furniture(this);
        }

    } // the builder class end here


    @Override
    public String toString() {
        return "Furniture{" + "FurnitureId=" + furnitureId + ", " +
                "FurnitureTypeId=" + furnitureTypeId + '}';
    }

}// end of the entire class















