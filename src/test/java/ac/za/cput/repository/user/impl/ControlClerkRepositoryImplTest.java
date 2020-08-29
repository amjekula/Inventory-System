package ac.za.cput.repository.user.impl;

/*
 *@author @amjekula
 * Description: Test Cases for Control Clerk Implementation
 * Date: 28 August 2020
 */

import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.factory.user.ControlClerkFactory;
import ac.za.cput.repository.user.ControlClerkRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ControlClerkRepositoryImplTest {
    private static ControlClerkRepository clerkRepository = ControlClerkRepositoryImpl.getControlClerkRepository();
    private static ControlClerk clerkBuilder = ControlClerkFactory.createControlClerk("Mjekuula", "Athi",
            "0792 565 854", "at@gmail.com");

    @Test
    public void a_create() {
        ControlClerk createClerk = clerkRepository.create(clerkBuilder);
        assertEquals(createClerk.getClerkId(), createClerk.getClerkId());
        System.out.println("Create: " + createClerk + "\n");
    }

    @Test
    public void b_read() {
        ControlClerk readClerk = clerkRepository.read(clerkBuilder.getClerkId());
        assertNotNull(readClerk);
        System.out.println("Read: " + readClerk + "\n");
    }

    @Test
    public void c_update() {
        ControlClerk updateClerk = new ControlClerk.ControlClerkBuilder().copy(clerkBuilder).setSurname("Mjekula").build();
        updateClerk = clerkRepository.update(updateClerk);
        assertNotEquals(clerkBuilder.getSurname(), updateClerk.getSurname());
        System.out.println("Update: " + updateClerk + "\n");
    }

    @Test
    public void e_delete() {
        clerkRepository.delete(clerkBuilder.getClerkId());
        assertEquals(clerkRepository.getAll().size(), 0);
        System.out.println("Check if Object is deleted: " + clerkRepository.getAll());
    }

    @Test
    public void d_getAll() {
        Set<ControlClerk> clerkSet = clerkRepository.getAll();
        assertEquals(1, clerkSet.size());
        System.out.println("All Users: " + clerkRepository.getAll() + "\n");
    }
}