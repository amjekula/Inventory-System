package ac.za.cput.entity;

public class FurnitureType {

    private final int furniture_Type_Id;
    private final String furniture_Description;
    private final double size;
    private final String color;


    private FurnitureType(Builder builder){

        this.furniture_Type_Id = builder.furniture_Type_Id;
        this.furniture_Description = builder.furniture_Description;
        this.size = builder.size;
        this.color = builder.color;


    }

    public int getFurniture_Type_Id(){

        return furniture_Type_Id;

    }

    public String getFurniture_Description(){

        return furniture_Description;

    }

    public double getSize(){

        return size;

    }

    public String getColor(){


        return color;

    }

    public static class Builder{

        private int furniture_Type_Id;
        private String furniture_Description;
        private double size;
        private String color;

        public Builder setFurniture_Type_Id( final int furniture_Type_Id){

            this.furniture_Type_Id = furniture_Type_Id;
            return this;
        }

        public Builder setFurniture_Description( final String furniture_Description){

            this.furniture_Description = furniture_Description;
            return this;
        }

        public Builder setSize(final double size){

            this.size =size;
            return this;

        }


        public Builder setColor(final String color){

            this.color = color;
            return this;

        }


        public Builder type(FurnitureType furnitureType){

            this.furniture_Type_Id = furnitureType.furniture_Type_Id;
            this.furniture_Description= furnitureType.furniture_Description;
            this.size = furnitureType.size;
            this.color = furnitureType.color;

            return this;

        }

        public FurnitureType build(){

            return new FurnitureType(this);

        }


    }

    @Override
    public String toString() {
        return "FurnitureType{"+
                ", Furniture_Type_Id=" + furniture_Type_Id +
                ", Furniture_Description=" + furniture_Description +
                ", Size=" + size +
                ", Color=" + color +

                '}';
    }
}
