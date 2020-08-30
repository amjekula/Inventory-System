package ac.za.cput.repository.equipment.Impl;
/*Jodi Smit */
import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.repository.equipment.DeviceTypeRepository;

import java.util.HashSet;
import java.util.Set;

public class DeviceTypeRepositoryImpl implements DeviceTypeRepository<DeviceType, String> {

    private Set<DeviceType> deviceTypeDB;

    public DeviceTypeRepositoryImpl(){

        this.deviceTypeDB = new HashSet<>();

    }
    //Create
    @Override
    public DeviceType create(DeviceType deviceType){
        this.deviceTypeDB.add(deviceType);
        return deviceType;
    }

    //Read
    @Override
    public DeviceType read(String deviceTypeId) {
        DeviceType deviceType = this.deviceTypeDB.stream()
                .filter(l -> l.getDeviceTypeId().equalsIgnoreCase(deviceTypeId))
                .findAny()
                .orElse(null);
        return deviceType;
    }

    //Update
    @Override
    public DeviceType update(DeviceType deviceType) {
        DeviceType deviceType1 =read(deviceType.getDeviceTypeId());
        if(deviceType1 != null){
            this.deviceTypeDB.remove(deviceType);
            this.deviceTypeDB.add(deviceType);
        }
        return deviceType;
    }

    //Delete
    @Override
    public void delete(String deviceTypeId) {
        DeviceType deviceType = read(deviceTypeId);
        if (deviceType != null) this.deviceTypeDB.remove(deviceType);
    }


    public Set<DeviceType> getAll() {
        return this.deviceTypeDB;
    }
}
