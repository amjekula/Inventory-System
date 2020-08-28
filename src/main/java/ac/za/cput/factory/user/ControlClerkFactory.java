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
            JOptionPane.showMessageDialog(null, "Please Enter Your Surname",
                    "Surname Can't Be Empty", JOptionPane.WARNING_MESSAGE);

        }else if(firstName.trim().equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Your Name",
                    "Name Can't Be Empty", JOptionPane.WARNING_MESSAGE);

        }else if(phoneNum.trim().equals("") || phoneNum.trim().length() < 10 || phoneNum.trim().length() > 10
                && emailAddress.trim().equals("")){

            JOptionPane.showMessageDialog(null, "Please Enter Your Phone Number or Email",
                    "Phone Number or Email doesn't exist", JOptionPane.WARNING_MESSAGE);

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