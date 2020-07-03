package ac.za.cput.factory;

import ac.za.cput.entity.Furniture;

public class FurnitureFactory // start of the class
{
    public static Furniture getFurniture(int furniture_Id, int furniture_type_Id){ //calling or creating a method to action
        return new Furniture.Builder()
                .furniture_Id(furniture_Id)
                .furniture_type_Id(furniture_type_Id)
                .build();
    }

} //end of main class
