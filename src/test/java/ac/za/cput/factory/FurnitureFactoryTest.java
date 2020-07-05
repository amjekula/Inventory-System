package ac.za.cput.factory;

import ac.za.cput.entity.Furniture;
import org.junit.Test;

import static org.junit.Assert.*;

public class FurnitureFactoryTest {

    @Test
    public void CreateFurniture() {

        Furniture furniture = FurnitureFactory.CreateFurniture("45");
        System.out.println(furniture);



    }
}