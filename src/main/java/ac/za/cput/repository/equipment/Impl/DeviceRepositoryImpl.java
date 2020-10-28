package ac.za.cput.repository.equipment.Impl;

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.repository.equipment.DeviceRepository;
import java.util.HashSet;
import java.util.Set;

public class DeviceRepositoryImpl implements DeviceRepository
{
    private static DeviceRepository deviceRepository = null;
    private Set<Device> deviceDB;

    private DeviceRepositoryImpl(){

        this.deviceDB = new HashSet<>();

    }

    public static DeviceRepository getDeviceRepository(){

        if(deviceRepository == null){

            deviceRepository = new DeviceRepositoryImpl();
        }
        return deviceRepository;

    }


    @Override
    public Set<Device> getAll() {
        return this.deviceDB;
    }

    @Override
    public Device create(Device device) {
        this.deviceDB.add(device);
        return device;
    }

    @Override
    public Device read(String deviceId) {
        Device device = this.deviceDB.stream()
                .filter(l -> l.getDeviceId().equalsIgnoreCase(deviceId))
                .findAny()
                .orElse(null);
        return device;
    }

    @Override
    public Device update(Device device) {
        Device oldDevice =read(device.getDeviceId());
        if(oldDevice != null){
            this.deviceDB.remove(oldDevice);
            this.deviceDB.add(device);
        }
        return device;
    }

    @Override
    public void delete(String deviceId) {

        Device device = read(deviceId);
        if (device != null) this.deviceDB.remove(device);

    }
}
