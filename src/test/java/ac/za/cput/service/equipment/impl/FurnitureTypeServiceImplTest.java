package ac.za.cput.service.equipment.impl;
//jodiSmit
import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.entity.equipment.FurnitureType;
import ac.za.cput.factory.equipment.DeviceTypeFactory;
import ac.za.cput.factory.equipment.FurnitureTypeFactory;
import ac.za.cput.service.equipment.DeviceTypeService;
import ac.za.cput.service.equipment.FurnitureTypeService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FurnitureTypeServiceImplTest {

    private static FurnitureTypeService service = FurnitureTypeServiceImpl.getService();
    private static FurnitureType furnitureTypeBuilder = FurnitureTypeFactory.createFurnitureType("Desk",5,"brown");



    @Test
    public void d_getAll() {

        Set<FurnitureType> furnitureTypes = service.getAll();
        assertEquals(1, furnitureTypes.size());
        System.out.println("All:" + furnitureTypes);
    }

    @Test
    public void a_create() {

        FurnitureType create = service.create(furnitureTypeBuilder);
        assertEquals(create.getFurnitureTypeId(), create.getFurnitureTypeId());
        System.out.println("Create:" + create );
    }

    @Test
    public void b_read() {

        FurnitureType read = service.read(furnitureTypeBuilder.getFurnitureTypeId());
        assertNotNull(read);
        System.out.println("Read:" + read);

    }

    @Test
    public void c_update() {

        FurnitureType update = new FurnitureType.Builder().setFurnitureDescription("table").setColor("Black").setSize(8).build();
        update = service.update(update);
        System.out.println("Update:" + update);
    }

    @Test
    public void e_delete() {
        service.delete(furnitureTypeBuilder.getFurnitureTypeId());
        assertEquals(service.getAll().size(), 0);
        System.out.println(service.getAll());
    }
}