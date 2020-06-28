package ac.za.cput.entity;


import org.junit.Test;

import static org.junit.Assert.*;

public class Device_TypeTest {

    Device_Type list = new Device_Type.Builder().setDeviceId(9).setDeviceDesc("Samsung").setDeviceSize(15).setDeviceColor("black").build();



    
    @Test
    public void getDeviceId()
    {
        assertEquals(9, list.getDeviceId());

    }


    @Test
    public void getDeviceDesc()
    {
        assertEquals("Samsung", list.getDeviceDesc());

    }

    @Test
    public void getFurnitureSize()
    {
        assertEquals(15, list.getDeviceId());

    }


    public void getFurnitureColor()
    {
        assertEquals("black", list.getDeviceColor());

    }

}