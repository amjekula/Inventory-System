package ac.za.cput.factory.equipment;
//JodiSmit

import ac.za.cput.entity.equipment.FurnitureType;
import ac.za.cput.factory.equipment.FurnitureTypeFactory;
import org.junit.Test;

public class FurnitureTypeFactoryTest {

    @Test
    public void createFurnitureType() {

        FurnitureType furnitureType = FurnitureTypeFactory.createFurnitureType("", 15, "Black");
        System.out.println(furnitureType);
    }
}