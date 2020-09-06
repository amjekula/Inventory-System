package ac.za.cput.service.equipment;

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.service.IService;

import java.util.Set;

public interface DeviceService extends IService<Device, String>
{
    Set<Device> getAll();
}
