package ac.za.cput.service.equipment.impl;

import static org.junit.Assert.*;

import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.entity.equipment.FurnitureType;
import ac.za.cput.entity.generic.Order;
import ac.za.cput.factory.equipment.FurnitureFactory;
import ac.za.cput.factory.generic.OrderFactory;
import ac.za.cput.service.equipment.FurnitureService;
import ac.za.cput.service.generic.OrderService;
import ac.za.cput.service.generic.impl.OrderServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FurnitureServiceImplTest {

 private  static FurnitureService service = FurnitureServiceImpl.getService ();
 private static Furniture furnitureBuilder = FurnitureFactory.createFurniture("234");


}