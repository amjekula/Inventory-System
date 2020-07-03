package ac.za.cput.factory;

import ac.za.cput.entity.Device;

public class DeviceFactory {

    public static Device getDevice (int Device_id,int Device_Type_id) {

        return new Device.Builder()
                .Device_id(Device_id)
                .Device_type_id(Device_Type_id)
                .build();

    }
}
