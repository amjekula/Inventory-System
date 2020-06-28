package ac.za.cput.entity;

public class Furniture_Type {
    
    private final int furnitureId;
    private final String furnitureDesc;
    private final double furnitureSize;
    private final String furnitureColor;


    private Furniture_Type(Builder builder){

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


     public Builder type(Furniture_Type furniture_Type){
         
     this.furnitureId = furniture_Type.furnitureId;
     this.furnitureDesc = furniture_Type.furnitureDesc;
     this.furnitureSize = furniture_Type.furnitureSize;
     this.furnitureColor = furniture_Type.furnitureColor;

     return this;
     
     }

     public Furniture_Type build(){

      return new Furniture_Type(this);

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