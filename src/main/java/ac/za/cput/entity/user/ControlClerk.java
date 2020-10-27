package ac.za.cput.entity.user;

import ac.za.cput.entity.generic.University;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/*
 *@author @amjekula
 * Description: Entity for Control Clerk
 * Date: 28 June 2020
 */

@Entity
public class ControlClerk implements Serializable {

    @Id
    private String clerkId;
    private String universityId, surname, firstName, phoneNum, emailAddress, password;

    //Create the foreign key
    /*@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<University> university;*/

    protected ControlClerk(){}

    private ControlClerk(ControlClerkBuilder controlClerkBuilder) {
        this.clerkId = controlClerkBuilder.clerkId;
        this.universityId = controlClerkBuilder.universityId;
        this.surname = controlClerkBuilder.surname;
        this.firstName = controlClerkBuilder.firstName;
        this.phoneNum = controlClerkBuilder.phoneNum;
        this.emailAddress = controlClerkBuilder.emailAddress;
        this.password = controlClerkBuilder.password;
    }

    public String getClerkId() {
        return clerkId;
    }

    public String getUniversityId() {
        return universityId;
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

    @Override
    public String toString() {
        return "ControlClerk{" +
                "clerkId='" + clerkId + '\'' +
                ", universityId='" + universityId + '\'' +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class ControlClerkBuilder{
        private String clerkId, universityId, surname, firstName, phoneNum, emailAddress, password;

        public ControlClerkBuilder setClerkId(String clerkId) {
            this.clerkId = clerkId;
            return this;
        }

        public ControlClerkBuilder setUniversityId(String universityId) {
            this.universityId = universityId;
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

        public ControlClerkBuilder copy(ControlClerk controlClerk){
            this.clerkId = controlClerk.clerkId;
            this.universityId = controlClerk.universityId;
            this.surname = controlClerk.surname;
            this.firstName = controlClerk.firstName;
            this.phoneNum = controlClerk.phoneNum;
            this.emailAddress = controlClerk.emailAddress;
            this.password = controlClerk.password;
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
