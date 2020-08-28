package ac.za.cput.factory.equipment;
//JodiSmit
import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.factory.equipment.DeviceTypeFactory;
import org.junit.Test;

public class DeviceTypeFactoryTest {

    @Test
    public void createDeviceType() {

        DeviceType deviceType = DeviceTypeFactory.createDeviceType("Dell",15, "Black");
        System.out.println(deviceType);
    }
}