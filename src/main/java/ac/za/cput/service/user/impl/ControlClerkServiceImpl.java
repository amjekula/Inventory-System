package ac.za.cput.service.user.impl;
/*
 *@author @amjekula
 * Description: Implementation for Control Clerk Service
 * Date: 05 September 2020
 */
import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.repository.user.ControlClerkRepository;
import ac.za.cput.service.user.ControlClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ControlClerkServiceImpl implements ControlClerkService {

    @Autowired
    private ControlClerkRepository repository;

    @Override
    public Set<ControlClerk> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public ControlClerk create(ControlClerk controlClerk) {
        return this.repository.save(controlClerk);
    }

    @Override
    public ControlClerk read(String ClerkId) {
        return this.repository.findById(ClerkId).orElseGet(null);
    }

    @Override
    public ControlClerk update(ControlClerk controlClerk) {
        if(this.repository.existsById(controlClerk.getClerkId())){

            return this.repository.save(controlClerk);
        }else {
            return null;
        }
    }

    @Override
    public void delete(String clerkId) {
        this.repository.deleteById(clerkId);
    }
}