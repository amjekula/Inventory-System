package ac.za.cput.entity;

public class FurnitureType {

    private final int furnitureId;
    private final String furnitureDesc;
    private final double furnitureSize;
    private final String furnitureColor;


    private FurnitureType(Builder builder){

        this.furnitureId = builder.furnitureId;
        this.furnitureDesc = builder.furnitureDesc;
        this.furnitureSize = builder.furnitureSize;
        this.furnitureColor = builder.furnitureColor;


    }

    public int getFurnitureId(){

        return furnitureId;

    }

    public String getFurnitureDesc(){

        return furnitureDesc;

    }

    public double getFurnitureSize(){

        return furnitureSize;

    }

    public String getfurnitureColor(){


        return furnitureColor;

    }

    public static class Builder{

        private int furnitureId;
        private String furnitureDesc;
        private double furnitureSize;
        private String furnitureColor;

        public Builder setFurnitureId( final int furnitureId){

            this.furnitureId = furnitureId;
            return this;
        }

        public Builder setFurnitureDesc( final String furnitureDesc){

            this.furnitureDesc = furnitureDesc;
            return this;
        }

        public Builder setFurnitureSize(final double furnitureSize){

            this.furnitureSize = furnitureSize;
            return this;

        }


        public Builder setFurnitureColor(final String furnitureColor){

            this.furnitureColor = furnitureColor;
            return this;

        }


        public Builder type(FurnitureType furnitureType){

            this.furnitureId = furnitureType.furnitureId;
            this.furnitureDesc = furnitureType.furnitureDesc;
            this.furnitureSize = furnitureType.furnitureSize;
            this.furnitureColor = furnitureType.furnitureColor;

            return this;

        }

        public FurnitureType build(){

            return new FurnitureType(this);

        }


    }

    @Override
    public String toString() {
        return "Furniture_Type{"+
                ", furnitureId=" + furnitureId +
                ", furnitureDesc=" + furnitureDesc +
                ", furnitureSize=" + furnitureSize +
                ", furnitureColor=" + furnitureColor +

                '}';
    }
}
