package ac.za.cput.factory;


import ac.za.cput.entity.Furniture;
import ac.za.cput.util.GenericHelper;

public class FurnitureFactory // start of the class
{
    public static Furniture CreateFurniture(String furnitureTypeId){ //calling or creating a method to action

        String  furnitureId = GenericHelper.generateId();
        Furniture furniture = new Furniture.Builder()
                .setFurnitureId(furnitureId)
                .setFurnitureTypeId(furnitureTypeId)
                .build();
        return furniture;


    }

} //end of main class
