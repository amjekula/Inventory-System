package ac.za.cput.repository.equipment.Impl;

import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.entity.user.Login;
import ac.za.cput.factory.equipment.DeviceTypeFactory;
import ac.za.cput.repository.equipment.DeviceTypeRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeviceTypeRepositoryImplTest {

    private static DeviceTypeRepository repo = new DeviceTypeRepositoryImpl();
    private static DeviceType deviceType = DeviceTypeFactory.createDeviceType("Samsung",5, "Black");
    private static DeviceType deviceType1 = DeviceTypeFactory.createDeviceType("Dell",3, "Blue");
    Set<DeviceType> deviceTypes = repo.getAll();

    @Test
    public void create() {
       DeviceType create =(DeviceType) repo.create(deviceType);
       assertEquals(deviceType.getDeviceTypeId(), create.getDeviceTypeId());
       System.out.println("Create=" + create);

    }

    @Test
    public void read() {

        DeviceType read =(DeviceType) repo.read(deviceType.getDeviceTypeId());
        assertEquals(deviceType.getDeviceTypeId(), read.getDeviceTypeId());
        System.out.println("Read=" + read);
    }

    @Test
    public void update() {
        DeviceType updated = new DeviceType.Builder().setDeviceDescription("Acer").setColor("Brown").setSize(4).build();
        updated = (DeviceType) repo.update(updated);
        assertEquals(deviceType.getDeviceTypeId(), updated.getDeviceTypeId());
        assertNotEquals(deviceType.getDeviceDescription(), updated.getDeviceDescription());
        assertNotEquals(deviceType, updated.getColor());
        assertNotEquals(deviceType,updated.getSize());
        System.out.println("Updated=" + updated);

    }

    @Test
    public void delete() {
        repo.delete(deviceType.getDeviceTypeId());
        assertNotNull(deviceType);
        System.out.print("\n" + "Removed DeviceTypeId:" + "  " + deviceType.getDeviceTypeId() + "\n");

    }

    @Test
    public void getAll() {
        System.out.println(repo.getAll());
    }
}