package ac.za.cput.repository.equipment.Impl;

import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface FurnitureRepository <F, S> extends IRepository<Furniture, String>
{
    Set<Furniture> getAll();
}
