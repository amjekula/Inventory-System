package ac.za.cput.entity.user;

import ac.za.cput.entity.generic.University;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/*
 *@author @amjekula
 * Description: Entity for Control Clerk
 * Date: 28 June 2020
 */

@Entity
public class ControlClerk implements Serializable {

    @Id
    private String clerkId;
    private String  surname, firstName, phoneNum, emailAddress, password, address, province;

    @ManyToOne
    private University university;

    protected ControlClerk(){}

    private ControlClerk(ControlClerkBuilder controlClerkBuilder) {
        this.clerkId = controlClerkBuilder.clerkId;
        this.university = controlClerkBuilder.university;
        this.surname = controlClerkBuilder.surname;
        this.firstName = controlClerkBuilder.firstName;
        this.phoneNum = controlClerkBuilder.phoneNum;
        this.emailAddress = controlClerkBuilder.emailAddress;
        this.password = controlClerkBuilder.password;
        this.address = controlClerkBuilder.address;
        this.province = controlClerkBuilder.province;
    }

    public String getClerkId() {
        return clerkId;
    }

    public University getUniversity() {
        return university;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getProvince() {
        return province;
    }

    public static class ControlClerkBuilder{
        private String clerkId, surname, firstName, phoneNum, emailAddress, password, address, province;
        private University university;

        public ControlClerkBuilder setUniversity(University university) {
            this.university = university;
            return this;
        }

        public ControlClerkBuilder setClerkId(String clerkId) {
            this.clerkId = clerkId;
            return this;
        }

        public ControlClerkBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public ControlClerkBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ControlClerkBuilder setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
            return this;
        }

        public ControlClerkBuilder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public ControlClerkBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public ControlClerkBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public ControlClerkBuilder setProvince(String province) {
            this.province = province;
            return this;
        }

        public ControlClerkBuilder copy(ControlClerk controlClerk){
            this.clerkId = controlClerk.clerkId;
            this.university = controlClerk.university;
            this.surname = controlClerk.surname;
            this.firstName = controlClerk.firstName;
            this.phoneNum = controlClerk.phoneNum;
            this.emailAddress = controlClerk.emailAddress;
            this.password = controlClerk.password;
            this.address = controlClerk.address;
            this.province = controlClerk.province;
            return this;
        }

        public ControlClerk build(){
            return new ControlClerk(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ControlClerk that = (ControlClerk) o;
        return clerkId.equals(that.clerkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clerkId);
    }
}
