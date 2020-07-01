package ac.za.cput.entity;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeviceTypeTest {


    DeviceType list = new DeviceType.Builder().setDeviceTypeId(9).setDeviceDescription("Samsung").setSize(15).setColor("black").build();




    @Test
    public void getDeviceTypeId()
    {
        assertEquals(9, list.getDeviceTypeId());

    }


    @Test
    public void getDeviceDescription()
    {
        assertEquals("Samsung", list.getDeviceDescription());

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
