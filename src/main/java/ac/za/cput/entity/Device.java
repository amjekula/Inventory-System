package ac.za.cput.entity;

public class Device {
    private int Device_id;
    private int Device_type_id;





    private Device(Builder builder){
        this.Device_id = builder.device_id;
        this.Device_type_id = builder.device_type_id;
    }

    public static class Builder {
        private int device_id;
        private int device_type_id;

        public void setDevice_id(int device_id) {
            this.device_id = device_id;
        }// Setter

        public void setDevice_type_id(int device_type_id) {
            this.device_type_id = device_type_id;
        } // Setter


        public int getDevice_id() {
            return device_id;
        }

        public int getDevice_type_id() {
            return device_type_id;
        }

        private Builder(int device_id,int device_type_id) {
            this.device_id = device_id;
            this.device_type_id = device_type_id;
        }

        public Device build () {
            return new Device(this);

        }

        public Builder copy(Device device) {
            this.device_id = device.Device_id;
            this.device_type_id = device.Device_type_id;



            return this;
        }

        @Override
        public String toString() {
            return "Device{" +
                    "device_id=" + device_id +
                    ", device_type_id=" + device_type_id +
                    '}';
        }

    }//Our Builder



} // Main
