package ac.za.cput.repository.equipment;

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface DeviceRepository extends JpaRepository <Device, String> {


}
