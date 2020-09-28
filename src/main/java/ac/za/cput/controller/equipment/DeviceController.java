package ac.za.cput.controller.equipment;

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.factory.equipment.DeviceFactory;
import ac.za.cput.service.equipment.impl.DeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("device")
public class DeviceController {

    @Autowired
    DeviceServiceImpl deviceService;


    @PostMapping("create")
    public Device create(@RequestBody Device device) {
        Device device1 = DeviceFactory.createDevice(device.getDeviceTypeId());

        return deviceService.create(device1);
    }


    @GetMapping("read")
    public Device read(@RequestParam("id")  String id) {
        return deviceService.read(id);
    }


    @PostMapping("update")
    public Device update(@RequestBody Device device) {
        return deviceService.update(device);
    }



    @GetMapping("all")
    public Set<Device> getAll() {

        return deviceService.getAll();
    }
}
