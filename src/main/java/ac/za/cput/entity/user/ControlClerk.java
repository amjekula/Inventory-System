package ac.za.cput.entity.user;
/*
 *@author @amjekula
 * Description: Entity for Control Clerk
 * Date: 28 June 2020
 */
public class ControlClerk {
    private String clerkId, universityId, surname, firstName, phoneNum, emailAddress;

    private ControlClerk(ControlClerkBuilder controlClerkBuilder) {
        this.clerkId = controlClerkBuilder.clerkId;
        this.universityId = controlClerkBuilder.universityId;
        this.surname = controlClerkBuilder.surname;
        this.firstName = controlClerkBuilder.firstName;
        this.phoneNum = controlClerkBuilder.phoneNum;
        this.emailAddress = controlClerkBuilder.emailAddress;
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

    @Override
    public String toString() {
        return "ControlClerk{" +
                "clerkId='" + clerkId + '\'' +
                ", universityId='" + universityId + '\'' +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public static class ControlClerkBuilder{
        private String clerkId, universityId, surname, firstName, phoneNum, emailAddress;

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

        public ControlClerkBuilder copy(ControlClerk controlClerk){
            this.clerkId = controlClerk.clerkId;
            this.universityId = controlClerk.universityId;
            this.surname = controlClerk.surname;
            this.firstName = controlClerk.firstName;
            this.phoneNum = controlClerk.phoneNum;
            this.emailAddress = controlClerk.emailAddress;
            return this;
        }

        public ControlClerk build(){
            return new ControlClerk(this);
        }
    }
}
