package ac.za.cput.repository.equipment.Impl;
/*Jodi Smit */
import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.factory.equipment.DeviceTypeFactory;
import ac.za.cput.repository.equipment.DeviceTypeRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeviceTypeRepositoryImplTest {


private static DeviceTypeRepository deviceTypeRepository = DeviceTypeRepositoryImpl.getDeviceTypeRepository();
private static DeviceType deviceTypeBuilder = DeviceTypeFactory.createDeviceType("Dell",5,"yellow");




    @Test
    public void create() {
      DeviceType createDeviceType = deviceTypeRepository.create(deviceTypeBuilder);
      assertEquals(createDeviceType.getDeviceTypeId(), createDeviceType.getDeviceTypeId());
      System.out.println("Create:" + createDeviceType );

    }

    @Test
    public void read() {

        DeviceType readDeviceType = deviceTypeRepository.read(deviceTypeBuilder.getDeviceTypeId());
        assertNotNull(readDeviceType);
        System.out.println("Read:" + readDeviceType);

    }

    @Test
    public void update() {
      DeviceType updateDeviceType = new DeviceType.Builder().setDeviceDescription("Acer").setColor("Black").setSize(8).build();
      updateDeviceType = deviceTypeRepository.update(updateDeviceType);
      System.out.println("Update:" + updateDeviceType);

    }

    @Test
    public void delete() {
       deviceTypeRepository.delete(deviceTypeBuilder.getDeviceTypeId());
       assertEquals(deviceTypeRepository.getAll().size(), 0);
       System.out.println(deviceTypeRepository.getAll());

    }

    @Test
    public void getAll() {

        Set <DeviceType> deviceTypeSet = deviceTypeRepository.getAll();
        System.out.println(deviceTypeRepository.getAll());


    }
}