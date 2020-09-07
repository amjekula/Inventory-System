package ac.za.cput.repository.equipment.Impl;

import ac.za.cput.entity.equipment.Device;
import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.repository.equipment.FurnitureRepository;

import java.util.HashSet;
import java.util.Set;

public class FurnitureRepositoryImpl implements FurnitureRepository {


    private static FurnitureRepository furnitureRepository = null;
    private Set<Furniture> furnitureDB;

    private FurnitureRepositoryImpl(){

        this.furnitureDB = new HashSet<>();
    }

    public static FurnitureRepository getFurnitureRepository(){

        if(furnitureRepository== null){

            furnitureRepository = new FurnitureRepositoryImpl();
        }
        return furnitureRepository;

    }

    @Override
    public Set<Furniture> getAll() {

        return this.furnitureDB;
    }

    @Override
    public Furniture create(Furniture furniture) {
        this.furnitureDB.add(furniture);
        return furniture;
    }

    @Override
    public Furniture read(String furnitureId) {

          Furniture furniture = this.furnitureDB.stream()
                .filter(l -> l.getFurnitureId().equalsIgnoreCase(furnitureId))
                .findAny()
                .orElse(null);
        return furniture;
    }


    @Override
    public Furniture update(Furniture furniture) {
        Furniture oldDevice =read(furniture.getFurnitureId());
        if(oldDevice != null){
            this.furnitureDB.remove(oldDevice);
            this.furnitureDB.add(furniture);
        }
        return furniture;
    }

    @Override
    public void delete(String furnitureId) {
        Furniture furniture = read(furnitureId);
        if (furniture != null) this.furnitureDB.remove(furniture);


    }
}
