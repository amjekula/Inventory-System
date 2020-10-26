package ac.za.cput.service.equipment.impl;

import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.repository.equipment.FurnitureRepository;

import ac.za.cput.service.equipment.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FurnitureServiceImpl implements FurnitureService
{
    private static FurnitureService service = null;

    @Autowired
    private FurnitureRepository repository;



    @Override
    public Set<Furniture> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Furniture create(Furniture furnitureId) {
        return this.repository.save(furnitureId);
    }

    @Override
    public Furniture read(String furniture) {
        return this.repository.findById(furniture).orElseGet(null);
    }

    @Override
    public Furniture update(Furniture furniture) {
        if (this.repository.existsById(furniture.getFurnitureId()))
        return this.repository.save(furniture);
        return null;
    }

    @Override
    public boolean delete(String furnitureId) {
        this.repository.deleteById(furnitureId);
        if (this.repository.existsById(furnitureId)) return false;
        else return false;
    }
}
