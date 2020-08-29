package ac.za.cput.factory.user;

/*
 *@author @amjekula
 * Description: Factory for Control Clerk
 * Date: 2 June 2020
 */

import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.util.GenericHelper;

import javax.swing.*;

public class ControlClerkFactory {

    public static ControlClerk createControlClerk(String surname, String firstName,
                                                  String phoneNum, String emailAddress){

        //Getting the Primary keys
        String clerkId = GenericHelper.generateId();
        String universityId = GenericHelper.generateId();
        //String universityId = String.valueOf(new University.Builder().build().getUniversityId());

        ControlClerk controlClerk = null;

        if(surname.trim().equals("")){
            System.out.println("Surname Can't Be Empty");

        }else if(firstName.trim().equals("")){
            System.out.println("Name Can't Be Empty");

        }else if(phoneNum.trim().equals("") || phoneNum.trim().length() < 10 || phoneNum.trim().length() > 10
                && emailAddress.trim().equals("")){
            System.out.println("Phone Number or Email doesn't exist");

        }else{
            controlClerk = new ControlClerk.ControlClerkBuilder()
                    .setClerkId(clerkId)
                    .setUniversityId(universityId)
                    .setSurname(surname.trim())
                    .setFirstName(firstName.trim())
                    .setPhoneNum(phoneNum.trim())
                    .setEmailAddress(emailAddress.trim())
                    .build();
        }
        return controlClerk;
    }
}