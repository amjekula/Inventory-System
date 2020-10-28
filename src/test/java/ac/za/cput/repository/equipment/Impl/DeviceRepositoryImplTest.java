//package ac.za.cput.repository.equipment.Impl;
///*Emile Lubangi */
//
//import ac.za.cput.entity.equipment.Device;
//import ac.za.cput.factory.equipment.DeviceFactory;
//import ac.za.cput.repository.equipment.DeviceRepository;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Set;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class DeviceRepositoryImplTest {
//
//@Autowired
//private static DeviceRepository deviceRepository ;
//private static Device deviceBuilder = DeviceFactory.createDevice("5665");
//
//
//
//
//
//    @Test
//    public void d_getAll() {
//
//        Set <Device> deviceSet = deviceRepository.findAll();
//        System.out.println(deviceRepository.findAll());
//
//
//    }
//
//    @Test
//    public void a_create() {
//      Device createDevice = deviceRepository.save(deviceBuilder);
//      assertEquals(createDevice.getDeviceTypeId(), createDevice.getDeviceId());
//      System.out.println("Create:" + createDevice );
//
//    }
//
//    @Test
//    public void b_read() {
//
//        Device readDevice = deviceRepository.read(deviceBuilder.getDeviceId());
//        assertNotNull(readDevice);
//        System.out.println("Read:" + readDevice);
//
//    }
//
//    @Test
//    public void c_update() {
//      Device updateDevice = new Device.Builder().copy(deviceBuilder).setDeviceId("5675").build();
//      updateDevice = deviceRepository.save(updateDevice);
//      System.out.println("Update:" + updateDevice);
//
//    }
//
//    @Test
//    public void e_delete() {
//       deviceRepository.delete(deviceBuilder.getDeviceId());
//       assertEquals(deviceRepository.getAll().size(), 0);
//       System.out.println(deviceRepository.getAll());
//
//    }
//
//
//}