package ac.za.cput.factory;

import ac.za.cput.entity.Device;

import ac.za.cput.util.GenericHelper;

public class DeviceFactory {

        public static Device createDevice(String deviceTypeId){
            String deviceId = GenericHelper.generateId();
            Device device =new Device.Builder()
                    .setDeviceId(deviceId)
                    .setDeviceTypeId(deviceTypeId)
                    .build();
            return device;


        }
}
