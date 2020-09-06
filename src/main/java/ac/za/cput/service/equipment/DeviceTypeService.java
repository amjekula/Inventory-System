package ac.za.cput.service.equipment;
//JodiSmit
import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.service.IService;

import java.util.Set;

public interface DeviceTypeService extends IService<DeviceType, String> {

    Set<DeviceType> getAll();
}
