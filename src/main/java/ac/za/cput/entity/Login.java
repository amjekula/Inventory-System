package ac.za.cput.entity;

public class Login {
    private  String email_address;
    private int password;


    private Login (Builder builder){
        this.email_address= builder.email_address;
        this.password= builder.password;

    }
    public static class Builder{
        private String email_address;
        private int password;

        public Builder setEmail_address(final String email_address)
        {
            this.email_address= email_address;
            return this;
        }
        public Builder setPassword(final int password)
        {
            this.password= password;
            return this;
        }

        public Builder copy(ac.za.cput.entity.Login login){
            this.email_address= login.email_address;
            this.password= login.password;
            return this;
        }
        public ac.za.cput.entity.Login build() {
            return new ac.za.cput.entity.Login(this);
        }

    }

    public String getEmail_address() {
        return email_address;
    }

    public int getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "email_address='" + email_address + '\'' +
                ", password=" + password +
                '}';
    }
}


