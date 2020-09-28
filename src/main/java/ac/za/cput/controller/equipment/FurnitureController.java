package ac.za.cput.controller.equipment;
import ac.za.cput.entity.equipment.Furniture;
import ac.za.cput.factory.equipment.FurnitureFactory;
import ac.za.cput.service.equipment.impl.FurnitureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/furniture")
public class FurnitureController {


    @Autowired
    private FurnitureServiceImpl furnitureService;

    @PostMapping("create")

    public Furniture create(@RequestBody Furniture furniture) {
        Furniture furniture1 = FurnitureFactory.createFurniture(furniture.getFurnitureTypeId());
        return furnitureService.create(furniture1);
    }
    @DeleteMapping ("/delete/{furnitureId}")

    public void  delete  ( @PathVariable String furnitureId) {

        furnitureService.delete(furnitureId);
    }
    @GetMapping("read")
    public Furniture read(String id) {

        return furnitureService.read(id);
    }

    @PostMapping("/Update")
    public Furniture update(Furniture furniture) {

        return furnitureService.update(furniture);
    }

    @GetMapping("/all")
    public Set<Furniture> getAll() {

        return furnitureService.getAll();
    }
}
