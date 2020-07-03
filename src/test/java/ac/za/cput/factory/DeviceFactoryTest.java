package ac.za.cput.factory;

import ac.za.cput.entity.Device;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeviceFactoryTest {

    @Test
    public void getDevice() {
        Device device = DeviceFactory.getDevice(1,2);
        Assert.assertEquals(1 ,device.getDevice_id());


    }
}