package ac.za.cput.factory.equipment;

import ac.za.cput.entity.equipment.Furniture;
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
