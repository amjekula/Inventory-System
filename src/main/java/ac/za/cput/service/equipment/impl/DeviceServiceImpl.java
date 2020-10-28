package ac.za.cput.service.equipment.impl;

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.repository.equipment.DeviceRepository;

import ac.za.cput.service.equipment.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService
{


    private static DeviceService service = null;

    @Autowired
    private DeviceRepository repository;




    @Override
    public Set<Device> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Device create(Device deviceId) {
        return this.repository.save(deviceId);
    }

    @Override
    public Device read(String device) {
        return this.repository.findById(device).orElseGet(null);
    }

    @Override
    public Device update(Device device) {
if (this.repository.existsById(device.getDeviceId()))
        return this.repository.save(device);
return  null;
    }

    @Override
    public boolean delete(String deviceId) {
        this.repository.deleteById(deviceId);
        if (this.repository.existsById(deviceId)) return false ;
        else return false;

    }
}
