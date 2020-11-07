package ac.za.cput.repository.equipment;
/*Jodi Smit */
import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.entity.equipment.FurnitureType;
import ac.za.cput.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType,String> {
    //Set<DeviceType> getAll();
}
