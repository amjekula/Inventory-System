package ac.za.cput.controller.equipment;

import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.factory.equipment.DeviceTypeFactory;
import ac.za.cput.service.equipment.impl.DeviceTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//JodiSmit
import java.util.Set;

@RestController
@RequestMapping("/deviceType")
public class DeviceTypeController {

    @Autowired
    private DeviceTypeServiceImpl deviceTypeService;


   @PostMapping("/create")
    public DeviceType create(@ReuestBody DeviceType deviceType){

       DeviceType newDeviceType = DeviceTypeFactory.createDeviceType(deviceType.getDeviceDescription(),deviceType.getSize(),deviceType.getColor());
      return deviceTypeService.create(newDeviceType);

   }



   @GetMapping("/read/{id}")
    public DeviceType read(@PathVariable String id){
       return deviceTypeService.read(id);
   }


   @PostMapping("/Update")
    public DeviceType update(@RequestBody DeviceType deviceType){
       return deviceTypeService.update(deviceType);
   }

    @GetMapping("/all")
    public Set<DeviceType> getAll(){
        return deviceTypeService.getAll();
    }

   /* @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        this.deviceTypeService.delete(id);

    }
*/

}
