package ac.za.cput.factory;
//JodiSmit

import ac.za.cput.entity.FurnitureType;
import org.junit.Test;

import static org.junit.Assert.*;

public class FurnitureTypeFactoryTest {

    @Test
    public void createFurnitureType() {

        FurnitureType furnitureType = FurnitureTypeFactory.createFurnitureType("", 15, "Black");
        System.out.println(furnitureType);
    }
}