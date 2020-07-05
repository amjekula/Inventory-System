package ac.za.cput.factory;

import ac.za.cput.entity.Device;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeviceFactoryTest {

    @Test
    public void createDevice() {
        Device device = DeviceFactory.createDevice(" 764");
        System.out.println(device);
    }

}