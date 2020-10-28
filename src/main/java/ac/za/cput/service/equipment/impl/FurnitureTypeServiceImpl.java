package ac.za.cput.service.equipment.impl;


import ac.za.cput.entity.equipment.Device;
import ac.za.cput.entity.equipment.FurnitureType;
import ac.za.cput.repository.equipment.FurnitureTypeRepository;
//import ac.za.cput.repository.equipment.Impl.FurnitureTypeRepositoryImpl;
import ac.za.cput.service.equipment.FurnitureTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//JodiSmit
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FurnitureTypeServiceImpl implements FurnitureTypeService {


    @Autowired
    private FurnitureTypeRepository repository;

    @Override
    public Set<FurnitureType> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public FurnitureType create(FurnitureType furnitureType) {
        return this.repository.save(furnitureType);
    }

    @Override
    public FurnitureType read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public FurnitureType update(FurnitureType furnitureType) {
        return this.repository.save(furnitureType);
    }

    @Override
    public void delete(String s) {

        this.repository.deleteById(s);

    }
}
