package ac.za.cput.entity;

public class Furniture {

    private int furniture_Id,furniture_type_Id;

    private Furniture (FurnitureBuilder builder) {
        this.furniture_Id = builder.furniture_Id;
        this.furniture_type_Id = builder.furniture_type_Id;


    }//Constructor Builder

    public static class FurnitureBuilder {
        private  int furniture_Id;
        private  int furniture_type_Id;


        public int getFurniture_Id() {
            return furniture_Id;
        }// getter Furniture_Id

        public int getFurniture_type_Id() {
            return furniture_type_Id;
        }// getter Furniture_type_Id

        private FurnitureBuilder (int furniture_Id, int furniture_type_Id) {
            this.furniture_Id = furniture_Id;
            this.furniture_type_Id=furniture_type_Id;

        }// F2

        public FurnitureBuilder setFurniture_Id (int Furniture_Id) {
            this.furniture_Id = furniture_Id;
            return this;
        }// setter Furniture ID

        public FurnitureBuilder setFurniture_type_Id (int Furniture_tye_Id) {
            this.furniture_type_Id = furniture_type_Id;
            return this;
        } // Setter Type ID


        public  Furniture build () {
            return new Furniture(this);

        }//Build

        @Override
        public String toString() {
            return "Furniture{" +
                    "furniture_Id=" + furniture_Id +
                    ", furniture_type_Id=" + furniture_type_Id +
                    '}';
        }





    } // builder

} //Main









