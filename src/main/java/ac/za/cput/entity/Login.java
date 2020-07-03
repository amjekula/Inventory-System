package ac.za.cput.entity;

public class Login {
    private String login_id;
    private  String email_address;
    private int password;


    protected Login(Builder builder){
        this.login_id= builder.login_id;
        this.email_address= builder.email_address;
        this.password= builder.password;


    }
    public static class Builder{
        private String login_id;
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
        public Builder setLogin_id(final String login_id)
        {
            this.login_id= login_id;
            return this;
        }

        public Builder copy(Login login){
            this.email_address= login.email_address;
            this.password= login.password;
            this.login_id= login.login_id;
            return this;
        }
        public Login build() {
            return new ac.za.cput.entity.Login(this);
        }

    }

    public String getEmail_address() {
        return email_address;
    }

    public int getPassword() {
        return password;
    }

    public String getLogin_id() {
        return login_id;
    }


    @Override
    public String toString() {
        return "Login{" +
                "email_address='" + email_address + '\'' +
                ", password=" + password +
                ", login_id="+ login_id +
                '}';
    }
}


