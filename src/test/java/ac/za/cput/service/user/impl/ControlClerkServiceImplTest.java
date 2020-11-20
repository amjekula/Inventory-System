package ac.za.cput.service.user.impl;
/*
 *@author @amjekula
 * Description: Test Cases for Control Clerk Service Implementation
 * Date: 05 September 2020
 */

import ac.za.cput.entity.generic.University;
import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.factory.generic.UniversityFactory;
import ac.za.cput.factory.user.ControlClerkFactory;
import ac.za.cput.service.user.ControlClerkService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControlClerkServiceImplTest {
    @Autowired
    private static ControlClerkService clerkService;
    private static University university = UniversityFactory.createUniversity("cput", "gtvt");

    private static ControlClerk clerkBuilder = ControlClerkFactory.createControlClerk(university, "Mjekuula", "Athi",
            "079 2565 854", "athi@gmail.com", "$852$0",
            "6 Varsity Street", "CPUT");

    @Test
    public void d_getAll() {
        Set<ControlClerk> clerkSet = clerkService.getAll();
        assertEquals(1, clerkSet.size());
        System.out.println("All Users: " + clerkService.getAll() + "\n");
    }

    @Test
    public void a_create() {
        ControlClerk createClerk = clerkService.create(clerkBuilder);
        assertEquals(createClerk.getClerkId(), createClerk.getClerkId());
        System.out.println("Create: " + createClerk + "\n");
    }

    @Test
    public void b_read() {
        ControlClerk readClerk = clerkService.read(clerkBuilder.getClerkId());
        assertNotNull(readClerk);
        System.out.println("Read: " + readClerk + "\n");
    }

    @Test
    public void c_update() {
        ControlClerk updateClerk = new ControlClerk.ControlClerkBuilder().copy(clerkBuilder).setSurname("Mjekula").build();
        updateClerk = clerkService.update(updateClerk);
        assertNotEquals(clerkBuilder.getSurname(), updateClerk.getSurname());
        System.out.println("Update: " + updateClerk + "\n");
    }

    @Test
    public void e_delete() {
        clerkService.delete(clerkBuilder.getClerkId());
        assertEquals(clerkService.getAll().size(), 0);
        System.out.println("Check if Object is deleted: " + clerkService.getAll());
    }
}