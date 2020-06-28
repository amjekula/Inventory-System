package ac.za.cput.entity;


import org.junit.Test;

import static org.junit.Assert.*;

public class Furniture_TypeTest {
    
    Furniture_Type list = new Furniture_Type.Builder().setFurnitureId(5).setFurnitureDesc("table").setFurnitureSize(15).setFurnitureColor("black").build();



    
    @Test
    public void getFurnitureId()
    {
        assertEquals(5, list.getFurnitureId());

    }


    @Test
    public void getFurnitureDesc()
    {
        assertEquals("table", list.getFurnitureDesc());

    }

    @Test
    public void getFurnitureSize()
    {
        assertEquals(15, list.getFurnitureId());

    }


    public void getFurnitureColor()
    {
        assertEquals("black", list.getfurnitureColor());

    }

}