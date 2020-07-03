package ac.za.cput.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class FurnitureTypeTest {

    FurnitureType list = new FurnitureType.Builder().setFurniture_Type_Id(5).setFurniture_Description("table").setSize(15).setColor("black").build();




    @Test
    public void getFurniture_Type_Id()
    {
        assertEquals(5, list.getFurniture_Type_Id());

    }


    @Test
    public void getFurnitureDescription()
    {
        assertEquals("table", list.getFurniture_Description());

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
