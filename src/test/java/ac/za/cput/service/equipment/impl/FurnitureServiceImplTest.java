package ac.za.cput.service.equipment.impl;

import static org.junit.Assert.*;



import ac.za.cput.entity.equipment.Furniture;

import ac.za.cput.factory.equipment.FurnitureFactory;

import ac.za.cput.service.equipment.FurnitureService;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FurnitureServiceImplTest {

    private  static FurnitureService service = FurnitureServiceImpl.getService ();
    private static Furniture furnitureBuilder = FurnitureFactory.createFurniture("234");


    @Test
    public void d_getAll() {
        Set<Furniture> furnitures = service.getAll();
        assertEquals(1,furnitures.size());
        System.out.println("All:" + furnitures);
    }

    @Test
    public void a_create() {
        Furniture create = service.create(furnitureBuilder);
        assertEquals(create.getFurnitureId(), create.getFurnitureId());
        System.out.println("Create:" + create );
    }

    @Test
    public void b_read() {

        Furniture read = service.read(furnitureBuilder.getFurnitureId());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    public void c_update() {
        Furniture update = new Furniture.Builder().copy(furnitureBuilder).setFurnitureId("123").build();
        update = service.update(update);
        System.out.println("Update:" + update);
    }

    @Test
    public void e_delete() {
        service.delete(furnitureBuilder.getFurnitureId());
        assertEquals(service.getAll().size(), 0);
        System.out.println(service.getAll());
    }
}