package ac.za.cput.controller.equipment;

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.factory.equipment.DeviceFactory;
import ac.za.cput.service.equipment.impl.DeviceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class DeviceController {

    @Autowired
    DeviceServiceImpl deviceService;


    @PostMapping("create")

    public Device create(@RequestBody Device device) {
        Device device1 = DeviceFactory.createDevice(device.getDeviceTypeId());

        return deviceService.create(device1);
    }

    @PostMapping("delete")

    public Device delete(@RequestBody Device device) {

        return deviceService.delete(String.valueOf(device));
    }

    @GetMapping("read")

    public Device read(@RequestParam("id")  String id) {
        return deviceService.read(id);
    }

    @PostMapping("update")

    public Device update(@RequestBody Device device) {
        return deviceService.update(device);
    }

    @GetMapping("reads")

    public List<Device> readAll() {
        return deviceService.readAll();
    }
}
