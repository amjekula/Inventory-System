package ac.za.cput.service.equipment;
//JodiSmit
import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.entity.equipment.FurnitureType;
import ac.za.cput.service.IService;

import java.util.Set;

public interface FurnitureTypeService extends IService<FurnitureType, String> {

    Set<FurnitureType> getAll();
}
