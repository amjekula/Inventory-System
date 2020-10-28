package ac.za.cput.service.equipment.impl;

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.repository.equipment.DeviceTypeRepository;
//import ac.za.cput.repository.equipment.Impl.DeviceTypeRepositoryImpl;
import ac.za.cput.service.equipment.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Set;
import java.util.stream.Collectors;
//JodiSmit

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {


    @Autowired
    private DeviceTypeRepository repository;

    @Override
    public Set<DeviceType> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public DeviceType create(DeviceType deviceType) {
        return this.repository.save(deviceType);
    }

    @Override
    public DeviceType read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public DeviceType update(DeviceType deviceType) {
        return this.repository.save(deviceType);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }
}
