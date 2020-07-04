package ac.za.cput.factory;

import ac.za.cput.entity.DeviceType;
import ac.za.cput.entity.FurnitureType;
import org.junit.Test;

import static org.junit.Assert.*;

public class FurnitureTypeFactoryTest {

    @Test
    public void createFurnitureType(){

        FurnitureType furnitureType = FurnitureTypeFactory.createFurnitureType("table", 15, "black");
        assertEquals("table",furnitureType.getFurnitureDescription());
        assertEquals(15,furnitureType.getSize());
        assertEquals("black",furnitureType.getColor());


    }

}
