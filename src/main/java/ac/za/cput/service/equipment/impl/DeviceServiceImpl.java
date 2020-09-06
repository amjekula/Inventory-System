package ac.za.cput.service.equipment.impl;

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.repository.equipment.Impl.DeviceRepositoryImpl;
import ac.za.cput.service.equipment.DeviceService;

import java.util.Set;

public class DeviceServiceImpl implements DeviceService
{

    private static DeviceServiceImpl service = null;
    private DeviceRepositoryImpl repository;

    private DeviceServiceImpl ()
    {
        this.repository = (DeviceRepositoryImpl) DeviceServiceImpl.getService();
    }

    public static DeviceService getService(){
        if(service == null){
            service = new DeviceServiceImpl();
        }
        return service;
    }

    @Override
    public Set<Device> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Device create(Device deviceId) {
        return this.repository.create(deviceId);
    }

    @Override
    public Device read(String device) {
        return this.repository.read(device);
    }

    @Override
    public Device update(Device device) {
        return this.repository.update(device);
    }

    @Override
    public void delete(String deviceId) {
     this.repository.delete(deviceId);
    }
}
