package ac.za.cput.factory;

import ac.za.cput.entity.Furniture;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FurnitureFactoryTest {

    @Test
    public void createFurniture() {
        Furniture furniture = FurnitureFactory.getFurniture(3,4);
        Assert.assertEquals(3 ,furniture.getFurniture_Id());




    }

    @Test
    public void getFurniture() {


    }
}