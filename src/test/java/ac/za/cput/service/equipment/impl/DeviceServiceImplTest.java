package ac.za.cput.service.equipment.impl;

import static org.junit.Assert.*;

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.entity.equipment.Device;
import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.factory.equipment.DeviceFactory;
import ac.za.cput.service.equipment.DeviceService;
import ac.za.cput.service.equipment.DeviceService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

public class DeviceServiceImplTest {
    private  static DeviceService service = DeviceServiceImpl.getService ();
    private static Device deviceBuilder = DeviceFactory.createDevice("762");

    @Test
    public void a_getAll() {
        Set<Device> devices = service.getAll();
        assertEquals(2,devices.size());
        System.out.println("All:" + devices);
    }

    @Test
    public void a_create() {
        Device create = service.create(deviceBuilder);
        assertEquals(create.getDeviceId(), create.getDeviceId());
        System.out.println("Create:" + create );
    }

    @Test
    public void b_read() {

        Device read = service.read(deviceBuilder.getDeviceId());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update() {
        Device update = new Device.Builder().setDeviceId("634").build();
        update = service.update(update);
        System.out.println("Update:" + update);
    }

    @Test
    public void e_delete() {
        service.delete(deviceBuilder.getDeviceId());
        assertEquals(service.getAll().size(), 0);
        System.out.println(service.getAll());
    }
}