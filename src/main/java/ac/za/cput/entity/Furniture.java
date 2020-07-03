package ac.za.cput.entity;

public class Furniture //start of the class
{
    private int furniture_Id, furniture_type_Id;

    private Furniture(){}// defaut constructor

    public int getFurniture_Id() {
        return furniture_Id;
    }

    public int getFurniture_type_Id() {
        return furniture_type_Id;
    }


    public Furniture(Builder builder){ //this is the builder constructor

        this.furniture_Id = builder.furniture_Id;
        this.furniture_type_Id = builder.furniture_type_Id;

    }

    public static class Builder{ // the builder class start here now
        private int furniture_Id, furniture_type_Id;

        public Builder furniture_Id(int furniture_Id){
            this.furniture_Id = furniture_Id;
            return this;
        }

        public Builder furniture_type_Id(int furniture_type_Id){
            this.furniture_type_Id = furniture_type_Id;
            return this;
        }

        public Furniture build(){
            return new Furniture(this);
        }

    } // the builder class end here


    @Override
    public String toString() {
        return "Furniture{" + "furniture_Id=" + furniture_Id + ", furniture_type_Id=" + furniture_type_Id + '}';
    }

}// end of the entire class










