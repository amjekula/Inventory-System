package ac.za.cput.repository.equipment;
/*Jodi Smit */
import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface DeviceTypeRepository extends IRepository<DeviceType, String> {
    Set<DeviceType> getAll();

}
