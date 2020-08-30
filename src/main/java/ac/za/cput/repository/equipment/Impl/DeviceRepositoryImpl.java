package ac.za.cput.repository.equipment.Impl;

import ac.za.cput.entity.equipment.Device;

import java.util.HashSet;
import java.util.Set;

public class DeviceRepositoryImpl implements ac.za.cput.repository.equipment.Impl.DeviceRepository <Device, String>
{
    private Set<Device> deviceDB;

    public DeviceRepositoryImpl()
    {

        this.deviceDB = new HashSet<>();

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
        Device device1 =read(device.getDeviceId());
        if(device1 != null){
            this.deviceDB.remove(device);
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
