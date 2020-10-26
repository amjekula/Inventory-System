package ac.za.cput.repository.equipment;

import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface FurnitureRepository extends JpaRepository <Furniture, String> {



}