package ac.za.cput.repository.equipment.Impl;//package ac.za.cput.repository.equipment.Impl;
///*Emile Lubangi */
//
//import ac.za.cput.entity.equipment.Furniture;
//import ac.za.cput.factory.equipment.FurnitureFactory;
//import ac.za.cput.repository.equipment.FurnitureRepository;
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
//public class FurnitureRepositoryImplTest {
//
//@Autowired
//private static FurnitureRepository furnitureRepository ;
//private static Furniture FurnitureBuilder = FurnitureFactory.createFurniture("67584");
//
//
//
//
//
//    @Test
//    public void d_getAll() {
//
//        Set <Furniture> FurnitureSet = furnitureRepository.findAll();
//        System.out.println(furnitureRepository.findAll());
//
//
//    }
//
//    @Test
//    public void a_create() {
//      Device createFurniture = furnitureRepository.save(furnitureBuilder);
//      assertEquals(createFurniture.getFurnitureTypeId(), createFurniture.getFurnitureId());
//      System.out.println("Create:" + createFurniture );
//
//    }
//
//    @Test
//    public void b_read() {
//
//        Device readFurniture = FurnitureRepository.read(furnitureBuilder.getFurnitureId());
//        assertNotNull(readFurniture);
//        System.out.println("Read:" + readFurniture);
//
//    }
//
//    @Test
//    public void c_update() {
//      Device updateFurniture = new Furniture.Builder().copy(furnitureBuilder).setFurnitureId("5675").build();
//      updateDevice = furnitureRepository.save(updateFurniture);
//      System.out.println("Update:" + updateFurniture);
//
//    }
//
//    @Test
//    public void e_delete() {
//       deviceRepository.delete(furnitureBuilder.getFurnitureId());
//       assertEquals(furnitureRepository.getAll().size(), 0);
//       System.out.println(furnitureRepository.getAll());
//
//    }
//
//
//}