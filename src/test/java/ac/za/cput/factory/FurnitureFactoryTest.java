package ac.za.cput.factory;

import ac.za.cput.entity.Furniture;
import org.junit.Test;

import static org.junit.Assert.*;

public class FurnitureFactoryTest {

    @Test
    public void createFurniture() {

        Furniture furniture = FurnitureFactory.createFurniture("45");
        System.out.println(furniture);



    }
}