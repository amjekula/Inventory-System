package ac.za.cput.service.user.impl;
/*
 *@author @amjekula
 * Description: Implementation for Control Clerk Service
 * Date: 05 September 2020
 */
import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.repository.user.ControlClerkRepository;
import ac.za.cput.repository.user.impl.ControlClerkRepositoryImpl;
import ac.za.cput.service.user.ControlClerkService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class ControlClerkServiceImpl implements ControlClerkService {

    private static ControlClerkService service = null;
    private ControlClerkRepository repository;

    private ControlClerkServiceImpl(){
        this.repository = ControlClerkRepositoryImpl.getControlClerkRepository();
    }

    public static ControlClerkService getService(){
        if(service == null){
            service = new ControlClerkServiceImpl();
        }
        return service;
    }

    @Override
    public Set<ControlClerk> getAll() {
        return this.repository.getAll();
    }

    @Override
    public ControlClerk create(ControlClerk controlClerk) {
        return this.repository.create(controlClerk);
    }

    @Override
    public ControlClerk read(String ClerkId) {
        return this.repository.read(ClerkId);
    }

    @Override
    public ControlClerk update(ControlClerk controlClerk) {
        return this.repository.update(controlClerk);
    }

    @Override
    public void delete(String clerkId) {
        this.repository.delete(clerkId);
    }
}
