package ac.za.cput.repository.equipment.Impl;
/*Jodi Smit */

import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.entity.equipment.FurnitureType;
import ac.za.cput.factory.equipment.DeviceTypeFactory;
import ac.za.cput.factory.equipment.FurnitureFactory;
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


    private static FurnitureTypeRepository furnitureTypeRepository = FurnitureTypeRepositoryImpl.getFurnitureTypeRepository();
    private static FurnitureType furnitureTypeBuilder = FurnitureTypeFactory.createFurnitureType("Table",6, "brown");




    @Test
    public void create() {

        FurnitureType createFurnitureType = furnitureTypeRepository.create(furnitureTypeBuilder);
        assertEquals(createFurnitureType.getFurnitureTypeId(), createFurnitureType.getFurnitureTypeId());
        System.out.println("Create:" + createFurnitureType );

    }

    @Test
    public void read() {
        FurnitureType readFurnitureType = furnitureTypeRepository.read(furnitureTypeBuilder.getFurnitureTypeId());
        assertNotNull(readFurnitureType);
        System.out.println("Read:" + readFurnitureType);
    }

    @Test
    public void update() {

        FurnitureType updateFurnitureType = new FurnitureType.Builder().setFurnitureDescription("blackboard").setColor("Black").setSize(8).build();
        updateFurnitureType = furnitureTypeRepository.update(updateFurnitureType);
        System.out.println("Update:" + updateFurnitureType);
    }

    @Test
    public void delete() {
        furnitureTypeRepository.delete(furnitureTypeBuilder.getFurnitureTypeId());
        assertEquals(furnitureTypeRepository.getAll().size(), 0);
        System.out.println(furnitureTypeRepository.getAll());
    }

    @Test
    public void getAll() {

        Set <FurnitureType> furnitureTypeSet = furnitureTypeRepository.getAll();
        System.out.println(furnitureTypeRepository.getAll());


    }
}