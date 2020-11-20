package ac.za.cput.factory.user;

/*
 *@author @amjekula
 * Description: Factory for Control Clerk
 * Date: 2 June 2020
 */

import ac.za.cput.entity.generic.University;
import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.util.GenericHelper;

import javax.swing.*;

public class ControlClerkFactory {

    public static ControlClerk createControlClerk(University university, String surname, String firstName,
                                                  String phoneNum, String emailAddress, String password,
                                                  String address, String province){

        //Generating the Primary key
        String clerkId = GenericHelper.generateId();

        ControlClerk controlClerk = null;

        if(surname.trim().equals("")){
            System.out.println("Please enter your surname");

        }else if(firstName.trim().equals("")){
            System.out.println("Please enter your name");

        }else if(password.trim().equals("")){
            System.out.println("Please enter your password");

        }else if(phoneNum.trim().equals("") || phoneNum.trim().length() < 10 || phoneNum.trim().length() > 10
                && emailAddress.trim().equals("")){
            System.out.println("Phone Number or Email doesn't exist");

        }else{
            controlClerk = new ControlClerk.ControlClerkBuilder()
                    .setClerkId(clerkId)
                    .setUniversity(university)
                    .setSurname(surname.trim())
                    .setFirstName(firstName.trim())
                    .setPhoneNum(phoneNum.trim())
                    .setEmailAddress(emailAddress.trim())
                    .setPassword(password.trim())
                    .setAddress(address.trim())
                    .setProvince(province.trim())
                    .build();
        }
        return controlClerk;
    }
}