package ac.za.cput.factory;

import ac.za.cput.entity.Device;
import ac.za.cput.entity.Furniture;
import org.junit.Test;

public class DeviceFactoryTest {

    @Test
    public void createDevice() {

        Device device = DeviceFactory.createDevice("67675467");
        System.out.println(device);

     }

    }
