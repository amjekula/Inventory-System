package ac.za.cput.factory;

import ac.za.cput.entity.DeviceType;
import ac.za.cput.util.GenericHelper;



public class DeviceTypeFactory {

public static DeviceType createDeviceType(String deviceDescription, double size, String color){
    String deviceTypeId = GenericHelper.generateId();
    DeviceType deviceType = new DeviceType.Builder()
            .setDeviceTypeId(deviceTypeId)
            .setDeviceDescription( deviceDescription)
            .setSize(size)
            .setColor(color)
            .build();

    return deviceType;


}
}
