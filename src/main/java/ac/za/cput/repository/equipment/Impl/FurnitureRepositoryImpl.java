package ac.za.cput.repository.equipment.Impl;

import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.repository.IRepository;

import java.util.HashSet;
import java.util.Set;

public class FurnitureRepositoryImpl implements ac.za.cput.repository.equipment.Impl.FurnitureRepository<Furniture, String>
{

    private Set<Furniture> furnitureDB;

    public FurnitureRepositoryImpl(){

        this.furnitureDB = new HashSet<>();
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
        Furniture furniture1 =read(furniture.getFurnitureId());
        if(furniture1 != null){
            this.furnitureDB.remove(furniture);
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
