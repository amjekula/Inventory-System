package ac.za.cput.service.equipment.impl;


import ac.za.cput.entity.equipment.Device;
import ac.za.cput.entity.equipment.FurnitureType;
import ac.za.cput.repository.equipment.FurnitureTypeRepository;
import ac.za.cput.repository.equipment.Impl.FurnitureTypeRepositoryImpl;
import ac.za.cput.service.equipment.FurnitureTypeService;
import org.springframework.stereotype.Service;
//JodiSmit
import java.util.Set;

@Service
public class FurnitureTypeServiceImpl implements FurnitureTypeService {

    private static FurnitureTypeService service = null;
    private FurnitureTypeRepository repository;

    public FurnitureTypeServiceImpl(){

        this.repository = FurnitureTypeRepositoryImpl.getFurnitureTypeRepository();

    }

    public static FurnitureTypeService getService(){

        if(service == null) {service = new FurnitureTypeServiceImpl();}
        return service;

    }

    @Override
    public Set<FurnitureType> getAll() {
        return this.repository.getAll();
    }

    @Override
    public FurnitureType create(FurnitureType furnitureType) {
        return this.repository.create(furnitureType);
    }

    @Override
    public FurnitureType read(String s) {
        return this.repository.read(s);
    }

    @Override
    public FurnitureType update(FurnitureType furnitureType) {
        return this.repository.update(furnitureType);
    }

    @Override
    public void delete(String s) {

        this.repository.delete(s);

    }
}
