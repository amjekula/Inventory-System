package ac.za.cput.repository.user.impl;

/*
 *@author @amjekula
 * Description: Implementation for Control Clerk Repository
 * Date: 28 August 2020
 */

import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.factory.user.ControlClerkFactory;
import ac.za.cput.repository.user.ControlClerkRepository;

import java.util.HashSet;
import java.util.Set;

public class ControlClerkRepositoryImpl implements ControlClerkRepository {

    private Set<ControlClerk> controlClerkDB;
    private static ControlClerkRepository controlClerkRepository = null;

    private ControlClerkRepositoryImpl(){
        this.controlClerkDB = new HashSet<>();
    }

    public static ControlClerkRepository getControlClerkRepository(){
        if(controlClerkRepository == null){
            controlClerkRepository = new ControlClerkRepositoryImpl();
        }
        return controlClerkRepository;
    }

    @Override
    public ControlClerk create(ControlClerk controlClerk) {
        this.controlClerkDB.add(controlClerk);
        return controlClerk;
    }

    @Override
    public ControlClerk read(String controlClerkId) {
        ControlClerk controlClerk = null;

        for(ControlClerk clerk : this.controlClerkDB){
            if(clerk.getClerkId().equalsIgnoreCase(controlClerkId)){
                controlClerk = clerk;
                break;
            }
        }
        return controlClerk;
    }

    @Override
    public ControlClerk update(ControlClerk controlClerk) {
        ControlClerk oldClerk = read(controlClerk.getClerkId());

        if(oldClerk != null){
            this.controlClerkDB.remove(oldClerk);
            this.controlClerkDB.add(controlClerk);
        }
        return controlClerk;
    }

    @Override
    public void delete(String controlClerkId) {
        ControlClerk controlClerk = read(controlClerkId);
        if(controlClerk != null){
            this.controlClerkDB.remove(controlClerk);
        }
    }

    @Override
    public Set<ControlClerk> getAll() {
        return this.controlClerkDB;
    }
}
