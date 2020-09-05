package ac.za.cput.repository.equipment.Impl;
/*Jodi Smit */
import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.repository.equipment.DeviceTypeRepository;

import java.util.HashSet;
import java.util.Set;

public class DeviceTypeRepositoryImpl implements DeviceTypeRepository {
    private static DeviceTypeRepository deviceTypeRepository = null;
    private Set<DeviceType> deviceTypeDB;

    private DeviceTypeRepositoryImpl(){

        this.deviceTypeDB = new HashSet<>();

    }

    public static DeviceTypeRepository getDeviceTypeRepository(){

        if(deviceTypeRepository == null){

            deviceTypeRepository = new DeviceTypeRepositoryImpl();
        }
        return deviceTypeRepository;

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
     DeviceType deviceType = null;

        for(DeviceType dType : this.deviceTypeDB){
            if(dType.getDeviceTypeId().equalsIgnoreCase(deviceTypeId)){
                deviceType= dType;
                break;
            }
        }
        return deviceType;
    }

    //Update
    @Override
    public DeviceType update(DeviceType deviceType) {
        DeviceType oldDeviceType =read(deviceType.getDeviceTypeId());
        if(oldDeviceType != null){
            this.deviceTypeDB.remove(oldDeviceType);
            this.deviceTypeDB.add(deviceType);
        }
        return deviceType;
    }

    //Delete
    @Override
    public void delete(String deviceTypeId) {
        DeviceType deviceType = read(deviceTypeId);
        if (deviceType != null)
        {this.deviceTypeDB.remove(deviceType);}
    }

@Override
    public Set<DeviceType> getAll() {
        return this.deviceTypeDB;
    }
}
