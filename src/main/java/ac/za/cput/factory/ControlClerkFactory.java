package ac.za.cput.factory;

/*
 *@author @amjekula
 * Description: Factory for Control Clerk
 * Date: 2 June 2020
 */

import ac.za.cput.entity.ControlClerk;
import ac.za.cput.util.GenericHelper;

import javax.swing.*;

public class ControlClerkFactory {

    public static ControlClerk createControlClerk(String surname, String firstName,
                                                  String phoneNum, String email_address){

        String clerk_id = GenericHelper.generateId();
        String university_id = GenericHelper.generateId();

        ControlClerk controlClerk = null;

        if(surname.trim().equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Your Surname",
                    "Surname Can't Be Empty", JOptionPane.WARNING_MESSAGE);

        }else if(firstName.trim().equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Your Name",
                    "Name Can't Be Empty", JOptionPane.WARNING_MESSAGE);

        }else if(phoneNum.trim().equals("") || phoneNum.trim().length() < 10 || phoneNum.trim().length() > 10
                && email_address.trim().equals("")){

            JOptionPane.showMessageDialog(null, "Please Enter Your Phone Number or Email",
                    "Phone Number or Email doesn't exist", JOptionPane.WARNING_MESSAGE);

        }else{
            controlClerk = new ControlClerk.ControlClerkBuilder()
                    .setClerk_id(clerk_id)
                    .setUniversity_id(university_id)
                    .setSurname(surname.trim())
                    .setFirstName(firstName.trim())
                    .setPhoneNum(phoneNum.trim())
                    .setEmail_address(email_address.trim())
                    .build();
        }

        return controlClerk;
    }
}