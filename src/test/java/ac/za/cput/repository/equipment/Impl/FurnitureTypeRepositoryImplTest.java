package ac.za.cput.repository.equipment.Impl;

import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.entity.equipment.FurnitureType;
import ac.za.cput.factory.equipment.DeviceTypeFactory;
import ac.za.cput.factory.equipment.FurnitureTypeFactory;
import ac.za.cput.repository.equipment.DeviceTypeRepository;
import ac.za.cput.repository.equipment.FurnitureTypeRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FurnitureTypeRepositoryImplTest {

    private static FurnitureTypeRepository repo = new FurnitureTypeRepositoryImpl();
    private static FurnitureType furnitureType = FurnitureTypeFactory.createFurnitureType("table",5, "Black");
    private static FurnitureType furnitureType1 = FurnitureTypeFactory.createFurnitureType("chair",3, "Blue");
    Set<FurnitureType> furnitureTypes = repo.getAll();


    @Test
    public void create() {

        FurnitureType create =(FurnitureType) repo.create(furnitureType);
        assertEquals(furnitureType.getFurnitureTypeId(), create.getFurnitureTypeId());
        System.out.println("Create=" + create);

    }

    @Test
    public void read() {
        FurnitureType read =(FurnitureType) repo.read(furnitureType.getFurnitureTypeId());
        assertEquals(furnitureType.getFurnitureTypeId(), read.getFurnitureTypeId());
        System.out.println("Read=" + read);
    }

    @Test
    public void update() {

        FurnitureType updated = new FurnitureType.Builder().setFurnitureDescription("chair").setColor("brown").setSize(5).build();
        updated = (FurnitureType) repo.update(updated);
        assertEquals(furnitureType.getFurnitureTypeId(), updated.getFurnitureTypeId());
        assertNotEquals(furnitureType.getFurnitureDescription(), updated.getFurnitureDescription());
        assertNotEquals(furnitureType, updated.getColor());
        assertNotEquals(furnitureType, updated.getSize());
        System.out.println("Updated=" + updated);
    }

    @Test
    public void delete() {
        repo.delete(furnitureType.getFurnitureTypeId());
        assertNotNull(furnitureType);
        System.out.print("\n" + "Remove FurnitureType:" + "  " + furnitureType.getFurnitureTypeId() + "\n");
    }

    @Test
    public void getAll() {
        System.out.println(repo.getAll());
    }
}