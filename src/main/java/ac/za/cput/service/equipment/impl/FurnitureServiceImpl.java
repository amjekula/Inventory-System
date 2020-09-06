package ac.za.cput.service.equipment.impl;

import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.repository.equipment.Impl.FurnitureRepositoryImpl;
import ac.za.cput.service.equipment.FurnitureService;

import java.util.Set;

public class FurnitureServiceImpl implements FurnitureService
{
    private static FurnitureServiceImpl service = null;
    private FurnitureRepositoryImpl repository;

    private FurnitureServiceImpl()
    {
        this.repository = FurnitureRepositoryImpl.getRepository();
    }

    public static FurnitureService getService() {

        if(service == null) {service = new FurnitureServiceImpl();}
        return service;
    }

    @Override
    public Set<Furniture> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Furniture create(Furniture furniture) {
        return this.repository.create(furniture);
    }

    @Override
    public Furniture read(String furniture) {
        return this.repository.read(furniture);
    }

    @Override
    public Furniture update(Furniture furniture) {
        return this.repository.update(furniture);
    }

    @Override
    public void delete(String furniture) {

        this.repository.delete(furniture);

    }
}
