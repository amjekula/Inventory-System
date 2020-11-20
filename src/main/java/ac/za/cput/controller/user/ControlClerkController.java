package ac.za.cput.controller.user;
/*
 *@author @amjekula
 * Description: Implementation for Control Clerk Controller
 * Date: 27 September 2020
 */
import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.factory.user.ControlClerkFactory;
import ac.za.cput.service.user.impl.ControlClerkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
@RestController
@RequestMapping("/inventory/controlclerk")
public class ControlClerkController {
    @Autowired
    private ControlClerkServiceImpl controlClerkService;

    @PostMapping("/create")
    public ControlClerk create(@RequestBody ControlClerk controlClerk) {
        ControlClerk newControlClerk = ControlClerkFactory.createControlClerk(controlClerk.getUniversity(), controlClerk.getSurname(),
                controlClerk.getFirstName(), controlClerk.getPhoneNum(), controlClerk.getEmailAddress(),
                controlClerk.getPassword(), controlClerk.getAddress(), controlClerk.getProvince());

        return controlClerkService.create(newControlClerk);
    }

    @GetMapping("/read/{clerkId}")
    public ControlClerk read (@PathVariable String clerkId){
        return controlClerkService.read(clerkId);
    }

    @PostMapping("/update")
    public ControlClerk update (@RequestBody ControlClerk controlClerk){
        return controlClerkService.update(controlClerk);
    }

    @DeleteMapping("/delete/{clerkId}")
    public void delete (@PathVariable String clerkId){
        controlClerkService.delete(clerkId);
    }

    @GetMapping("/all")
    public Set<ControlClerk> getAll () {
        return controlClerkService.getAll();
    }
}
