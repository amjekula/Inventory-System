package ac.za.cput.entity;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeviceTypeTest {


    DeviceType list = new DeviceType.Builder().setDevice_Type_Id(9).setDevice_Description("Samsung").setSize(15).setColor("black").build();




    @Test
    public void getDevice_Type_Id()
    {
        assertEquals(9, list.getDevice_Type_Id());

    }


    @Test
    public void getDevice_Description()
    {
        assertEquals("Samsung", list.getDevice_Description());

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
