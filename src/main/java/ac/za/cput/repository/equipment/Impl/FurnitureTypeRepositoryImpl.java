package ac.za.cput.repository.equipment.Impl;
/*Jodi Smit */
import ac.za.cput.entity.equipment.FurnitureType;
import ac.za.cput.repository.equipment.FurnitureTypeRepository;

import java.util.HashSet;
import java.util.Set;

public class FurnitureTypeRepositoryImpl implements FurnitureTypeRepository<FurnitureType, String> {

    private Set<FurnitureType> furnitureTypeDB;

    public FurnitureTypeRepositoryImpl(){

        this.furnitureTypeDB = new HashSet<>();
    }

    //Create
    @Override
    public FurnitureType create(FurnitureType furnitureType){
        this.furnitureTypeDB.add(furnitureType);
        return furnitureType;
    }

    //Read
    @Override
    public FurnitureType read(String furnitureTypeId) {
        FurnitureType furnitureType = this.furnitureTypeDB.stream()
                .filter(l -> l.getFurnitureTypeId().equalsIgnoreCase(furnitureTypeId))
                .findAny()
                .orElse(null);
        return furnitureType;
    }

    //Update
    @Override
    public FurnitureType update(FurnitureType furnitureType) {
        FurnitureType furnitureType1 =read(furnitureType.getFurnitureTypeId());
        if(furnitureType1 != null){
            this.furnitureTypeDB.remove(furnitureType);
            this.furnitureTypeDB.add(furnitureType);
        }
        return furnitureType;
    }


    //Delete
    @Override
    public void delete(String furnitureTypeId) {
        FurnitureType furnitureType = read(furnitureTypeId);
        if (furnitureType != null) this.furnitureTypeDB.remove(furnitureType);
    }

    @Override
    public Set<FurnitureType> getAll() {
        return this.furnitureTypeDB;
    }

}
