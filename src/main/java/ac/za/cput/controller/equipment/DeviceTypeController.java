package ac.za.cput.controller.equipment;

import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.factory.equipment.DeviceTypeFactory;
import ac.za.cput.service.equipment.impl.DeviceTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//JodiSmit
import java.util.Set;

@RestController
@RequestMapping("/deviceType")
public class DeviceTypeController {

    @Autowired
    private DeviceTypeServiceImpl deviceTypeService;


    @PostMapping("/create")
    public DeviceType create(@RequestBody DeviceType deviceType){
        DeviceType newDeviceType = DeviceTypeFactory.createDeviceType(deviceType.getDeviceDescription(),deviceType.getSize(),deviceType.getColor());
        return deviceTypeService.create(newDeviceType);

    }

    @GetMapping("/read/{deviceTypeId}")
    public DeviceType read(@PathVariable String deviceTypeId){
        return deviceTypeService.read(deviceTypeId);
    }


    @PostMapping("/update")
    public DeviceType update(@RequestBody DeviceType deviceType){
        return deviceTypeService.update(deviceType);
    }

    @GetMapping("/all")
    public Set<DeviceType> getAll(){
        return deviceTypeService.getAll();
    }


    @DeleteMapping("/delete/{deviceTypeId}")
    public void delete(@PathVariable String deviceTypeId)
    {
        deviceTypeService.delete(deviceTypeId);
    }


}
