package ac.za.cput.entity;

public class Device {
    private int Device_id;
    private int Device_type_id;

    private Device (){}

    public int getDevice_id() {
        return Device_id;

    }

    public int getDevice_type_id() {
        return Device_type_id;

    }

    public Device (Builder builder){

    this.Device_id = builder.Device_id;
    this.Device_type_id = builder.Device_type_id;

    }//Builder constructor

    public static  class Builder {

        private int Device_id;
        private int Device_type_id;

    public Builder Device_id(int Device_id){

        return this;
    }

        public Builder Device_type_id(int Device_type_id){
            return this;
        }

        public Device build () {

            return new Device(this);




        }

        @Override
        public String toString() {
            return "Builder{" +
                    "Device_id=" + Device_id +
                    ", Device_type_id=" + Device_type_id +
                    '}';
        }
    }



} // Main
