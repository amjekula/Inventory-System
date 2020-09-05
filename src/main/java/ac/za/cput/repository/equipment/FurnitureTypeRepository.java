package ac.za.cput.repository.equipment;
/*Jodi Smit */
import ac.za.cput.entity.equipment.FurnitureType;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface FurnitureTypeRepository  extends IRepository<FurnitureType, String> {
    Set<FurnitureType> getAll();}


