package ac.za.cput.factory.equipment;

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.factory.equipment.DeviceFactory;
import org.junit.Test;

public class DeviceFactoryTest {

    @Test
    public void createDevice() {
        Device device = DeviceFactory.createDevice(" 764");
        System.out.println(device);
    }

}