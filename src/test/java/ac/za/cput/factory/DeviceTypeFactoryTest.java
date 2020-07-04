package ac.za.cput.factory;
import ac.za.cput.entity.DeviceType;
import org.junit.Test;

import static org.junit.Assert.*;


public class DeviceTypeFactoryTest {

    @Test
    public void createDeviceType(){

        DeviceType deviceType = DeviceTypeFactory.createDeviceType("Samsung", 15, "black");
        assertEquals("Samsung",deviceType.getDeviceDescription());
        assertEquals(15,deviceType.getSize());
        assertEquals("black",deviceType.getColor());


    }

}
