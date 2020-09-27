package ac.za.cput.controller.equipment;
import ac.za.cput.controller.IController;
import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.factory.equipment.FurnitureFactory;
import ac.za.cput.service.equipment.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

import static org.graalvm.compiler.nodeinfo.Verbosity.Id;

public class FunitureController implements IController<Furniture,String> {

    @Autowired
    FurnitureService furnitureService;

    @PostMapping("create")
    @Override
    public Furniture create(@RequestBody Furniture furniture) {
        Furniture furniture1 = FurnitureFactory.createFurniture(furniture.getFurnitureTypeId());
        return furnitureService.create(furniture1);
    }
    @PostMapping("delete")
    @Override
    public Furniture delete(Furniture furniture) {
        return furnitureService.delete(String.valueOf(furniture));
    }
    @GetMapping("read")
    @Override
    public Furniture read(String id) {
        return furnitureService.read(id);
    }

    @Override
    public Furniture update(Furniture furniture) {
        return furnitureService.update(furniture);
    }

    public Set<Furniture> getAll() {
        return furnitureService.getAll();
    }
}
