package ac.za.cput.controller.equipment;

import ac.za.cput.controller.IController;
import ac.za.cput.entity.equipment.Device;
import ac.za.cput.factory.equipment.DeviceFactory;
import ac.za.cput.service.equipment.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class DeviceController implements IController<Device,String> {

    @Autowired
    DeviceService deviceService;


    @PostMapping("create")
    @Override
    public Device create(@RequestBody Device device) {
        Device device1 = DeviceFactory.createDevice(device.getDeviceTypeId(),device.getDeviceId());

        return deviceService.create(device1);
    }

    @PostMapping("delete")
    @Override
    public Device delete(@RequestBody Device device) {

        return deviceService.delete(String.valueOf(device));
    }

    @GetMapping("read")
    @Override
    public Device read(@RequestParam("id")  String id) {
        return deviceService.read(id);
    }

    @PostMapping("update")
    @Override
    public Device update(@RequestBody Device device) {
        return deviceService.update(device);
    }

    @GetMapping("reads")
    @Override
    public List<Device> readAll() {
        return deviceService.readAll();
    }
}
