package ac.za.cput.service.equipment.impl;

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.repository.equipment.DeviceRepository;
import ac.za.cput.repository.equipment.Impl.DeviceRepositoryImpl;
import ac.za.cput.service.equipment.DeviceService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DeviceServiceImpl implements DeviceService
{

    private static DeviceService service = null;
    private DeviceRepository repository;

    private DeviceServiceImpl ()
    {
        this.repository = DeviceRepositoryImpl.getDeviceRepository();
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
