package ac.za.cput.entity;

public class ControlClerk {
    private String clerk_id, university_id, surname, firstName, phoneNum, email_address;

    private ControlClerk(ControlClerkBuilder controlClerkBuilder) {
        this.clerk_id = controlClerkBuilder.clerk_id;
        this.university_id = controlClerkBuilder.university_id;
        this.surname = controlClerkBuilder.surname;
        this.firstName = controlClerkBuilder.firstName;
        this.phoneNum = controlClerkBuilder.phoneNum;
        this.email_address = controlClerkBuilder.email_address;
    }

    public String getClerk_id() {
        return clerk_id;
    }

    public String getUniversity_id() {
        return university_id;
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

    public String getEmail_address() {
        return email_address;
    }

    @Override
    public String toString() {
        return "ControlClerk{" +
                "clerk_id='" + clerk_id + '\'' +
                ", university_id='" + university_id + '\'' +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email_address='" + email_address + '\'' +
                '}';
    }

    public static class ControlClerkBuilder{
        private String clerk_id, university_id, surname, firstName, phoneNum, email_address;

        public ControlClerkBuilder setClerk_id(String clerk_id) {
            this.clerk_id = clerk_id;
            return this;
        }

        public ControlClerkBuilder setUniversity_id(String university_id) {
            this.university_id = university_id;
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

        public ControlClerkBuilder setEmail_address(String email_address) {
            this.email_address = email_address;
            return this;
        }

        public ControlClerkBuilder copy(ControlClerk controlClerk){
            this.clerk_id = controlClerk.clerk_id;
            this.university_id = controlClerk.university_id;
            this.surname = controlClerk.surname;
            this.firstName = controlClerk.firstName;
            this.phoneNum = controlClerk.phoneNum;
            this.email_address = controlClerk.email_address;
            return this;
        }

        public ControlClerk build(){
            return new ControlClerk(this);
        }
    }
}
