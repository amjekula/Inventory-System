package ac.za.cput.service.equipment.impl;

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.repository.equipment.DeviceTypeRepository;
import ac.za.cput.repository.equipment.Impl.DeviceTypeRepositoryImpl;
import ac.za.cput.service.equipment.DeviceTypeService;
import org.springframework.stereotype.Service;


import java.util.Set;
//JodiSmit

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {
    private static DeviceTypeService service = null;
    private DeviceTypeRepository repository;

    public DeviceTypeServiceImpl(){

           this.repository = DeviceTypeRepositoryImpl.getDeviceTypeRepository();

    }

    public static DeviceTypeService getService(){

        if(service == null) {service = new DeviceTypeServiceImpl();}
        return service;

    }


    @Override
    public Set<DeviceType> getAll() {
        return this.repository.getAll();
    }

    @Override
    public DeviceType create(DeviceType deviceType) {
        return this.repository.create(deviceType);
    }

    @Override
    public DeviceType read(String s) {
        return this.repository.read(s);
    }

    @Override
    public DeviceType update(DeviceType deviceType) {
        return this.repository.update(deviceType);
    }

    @Override
    public void delete(String deviceId) {
        this.repository.delete(deviceId);
    }
}
