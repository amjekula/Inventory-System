package ac.za.cput.factory.equipment;

import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.factory.equipment.FurnitureFactory;
import org.junit.Test;

public class FurnitureFactoryTest {

    @Test
    public void createFurniture() {

        Furniture furniture = FurnitureFactory.createFurniture(" 134");
        System.out.println(furniture);
    }
}