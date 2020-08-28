package ac.za.cput.entity.generic;

import ac.za.cput.entity.generic.University;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 *  @author: Sherwin Adams
 *  Desc: Tests for University Entity
 */

public class UniversityTest {

    // Create cput
    University cput = new University.Builder().setUniversityId("1").setName("CPUT").setAddress("Hanover St, Zonnebloem, Cape Town, 7925").build();

    @Test
    public void getUniversityId() {
        assertEquals("1",cput.getUniversityId());
    }

    @Test
    public void getName() {
        assertEquals("CPUT",cput.getName());
    }

    @Test
    public void getLocation() {
        assertEquals("Hanover St, Zonnebloem, Cape Town, 7925",cput.getAddress());
    }
}