package ac.za.cput.factory;

import ac.za.cput.entity.Device;
import ac.za.cput.entity.Furniture;
import ac.za.cput.util.GenericHelper;

public class FurnitureFactory {

    public static Furniture createFurniture(String furnitureTypeId){
        String furnitureId = GenericHelper.generateId();
        Furniture furniture =new Furniture.Builder()
                .setFurnitureId(furnitureId)
                .setFurnitureTypeId(furnitureTypeId)
                .build();
        return furniture;


    }
}
