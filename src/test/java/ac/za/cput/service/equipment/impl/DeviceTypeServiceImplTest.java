package ac.za.cput.service.equipment.impl;
//JodiSmit
import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.factory.equipment.DeviceTypeFactory;
import ac.za.cput.service.equipment.DeviceTypeService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeviceTypeServiceImplTest {

    private static DeviceTypeService service = DeviceTypeServiceImpl.getService();
    private static DeviceType deviceTypeBuilder = DeviceTypeFactory.createDeviceType("Dell",5,"yellow");



    @Test
    public void d_getAll() {

        Set<DeviceType> deviceTypes = service.getAll();
        assertEquals(1, deviceTypes.size());
        System.out.println("All:" + deviceTypes);

    }

    @Test
    public void a_create() {
      DeviceType create = service.create(deviceTypeBuilder);
        assertEquals(create.getDeviceTypeId(), create.getDeviceTypeId());
        System.out.println("Create:" + create );
    }

    @Test
    public void b_read() {

        DeviceType read = service.read(deviceTypeBuilder.getDeviceTypeId());
        assertNotNull(read);
        System.out.println("Read:" + read);

    }

    @Test
    public void c_update() {
        DeviceType update = new DeviceType.Builder().setDeviceDescription("Acer").setColor("Black").setSize(8).build();
        update = service.update(update);
        System.out.println("Update:" + update);

    }

    @Test
    public void e_delete() {
        service.delete(deviceTypeBuilder.getDeviceTypeId());
        assertEquals(service.getAll().size(), 0);
        System.out.println(service.getAll());
    }
}