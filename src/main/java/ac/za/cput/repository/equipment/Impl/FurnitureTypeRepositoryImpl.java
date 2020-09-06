package ac.za.cput.repository.equipment.Impl;
/*Jodi Smit */
import ac.za.cput.entity.equipment.DeviceType;
import ac.za.cput.entity.equipment.FurnitureType;
import ac.za.cput.repository.equipment.DeviceTypeRepository;
import ac.za.cput.repository.equipment.FurnitureTypeRepository;

import java.util.HashSet;
import java.util.Set;

public class FurnitureTypeRepositoryImpl implements FurnitureTypeRepository{
    private static FurnitureTypeRepository furnitureTypeRepository = null;
    private Set<FurnitureType> furnitureTypeDB;

    private FurnitureTypeRepositoryImpl(){

        this.furnitureTypeDB = new HashSet<>();
    }

    public static FurnitureTypeRepository getFurnitureTypeRepository(){

        if(furnitureTypeRepository== null){

            furnitureTypeRepository = new FurnitureTypeRepositoryImpl();
        }
        return furnitureTypeRepository;

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
        FurnitureType furnitureType = null;

        for(FurnitureType fType : this.furnitureTypeDB){
            if(fType.getFurnitureTypeId().equalsIgnoreCase(furnitureTypeId)){
                furnitureType= fType;
                break;
            }
        }
        return furnitureType;
    }

    //Update
    @Override
    public FurnitureType update(FurnitureType furnitureType) {
        FurnitureType oldfurnitureType =read(furnitureType.getFurnitureTypeId());
        if(oldfurnitureType != null){
            this.furnitureTypeDB.remove(oldfurnitureType);
            this.furnitureTypeDB.add(furnitureType);
        }
        return furnitureType;
    }


    //Delete
    @Override
    public void delete(String furnitureTypeId) {
        FurnitureType furnitureType = read(furnitureTypeId);
        if (furnitureType != null){
            this.furnitureTypeDB.remove(furnitureType);}
    }

    @Override
    public Set<FurnitureType> getAll() {
        return this.furnitureTypeDB;
    }

}
