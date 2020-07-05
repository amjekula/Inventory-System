package ac.za.cput.factory;
//JodiSmit
import ac.za.cput.entity.DeviceType;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeviceTypeFactoryTest {

    @Test
    public void createDeviceType() {

        DeviceType deviceType = DeviceTypeFactory.createDeviceType("Dell",15, "Black");
        System.out.println(deviceType);
    }
}