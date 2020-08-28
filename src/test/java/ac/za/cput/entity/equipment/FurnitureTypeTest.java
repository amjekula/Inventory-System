package ac.za.cput.entity.equipment;

import ac.za.cput.entity.equipment.FurnitureType;
import org.junit.Test;

import static org.junit.Assert.*;

public class FurnitureTypeTest {

    FurnitureType list = new FurnitureType.Builder().setFurnitureTypeId("5").setFurnitureDescription("table").setSize(15).setColor("black").build();




    @Test
    public void getFurnitureTypeId()
    {
        assertEquals(5, list.getFurnitureTypeId());


    }


    @Test
    public void getFurnitureDescription()
    {
        assertEquals("table", list.getFurnitureDescription());

    }

    @Test
    public void getSize()
    {
        assertEquals(15, list.getSize());

    }


    public void getColor()
    {
        assertEquals("black", list.getColor());

    }

}
