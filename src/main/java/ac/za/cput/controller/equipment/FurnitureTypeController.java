package ac.za.cput.controller.equipment;



import ac.za.cput.entity.equipment.FurnitureType;
import ac.za.cput.factory.equipment.FurnitureTypeFactory;
import ac.za.cput.service.equipment.impl.FurnitureTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//Jodi Smit
import java.util.Set;

@RestController
@RequestMapping("/furnitureType")
public class FurnitureTypeController {

    @Autowired
    private FurnitureTypeServiceImpl furnitureTypeService;


    @PostMapping("/create")
    public FurnitureType create( @RequestBody FurnitureType furnitureType){
        FurnitureType newFurnitureType = FurnitureTypeFactory.createFurnitureType(furnitureType.getFurnitureDescription(),furnitureType.getSize(),furnitureType.getColor());
        return furnitureTypeService.create(newFurnitureType);
    }

    @GetMapping("/all")
    public Set<FurnitureType> getAll(){
        return  furnitureTypeService.getAll();
    }

    @GetMapping("/read/{furnitureTypeId}")
    public FurnitureType read(@PathVariable String furnitureTypeId){
        return furnitureTypeService.read(furnitureTypeId);}

    @PostMapping("/update")
    public FurnitureType update(@RequestBody FurnitureType furnitureType){
        return furnitureTypeService.update(furnitureType);
    }

    @DeleteMapping("/delete/{furnitureTypeId}")
    public void delete(@PathVariable String furnitureTypeId){ furnitureTypeService.delete(furnitureTypeId);}




}
