package ac.za.cput.repository.equipment;

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface DeviceRepository extends IRepository<Device, String>
{
    Set<Device> getAll();
}
