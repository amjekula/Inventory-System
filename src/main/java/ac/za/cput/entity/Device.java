package ac.za.cput.entity;

public class Device {
    private String deviceId;
    private String deviceTypeId;

    //getters
    public String getDeviceId() {
        return deviceId;

    }

    public String getDeviceTypeId() {
        return deviceTypeId;

    }


    public Device (Builder builder){

    this.deviceId = builder.deviceId;
    this.deviceTypeId = builder.deviceTypeId;

    }//Builder constructor

    public static  class Builder {

        private String deviceId;
        private String deviceTypeId;

        // setters
        public Builder setDeviceId(String deviceId) {
            this.deviceId=  deviceId;
            return this;
        }



        public Builder setDeviceTypeId(String deviceTypeId) {
            this.deviceTypeId = deviceTypeId;
            return this;
        }


        public Device.Builder copy (Device device){
            this.deviceId= device.deviceId;
            this.deviceTypeId= device.deviceTypeId;
            return this;
        }
        public Device build () {

            return new Device(this);

        }



        @Override
        public String toString() {
            return "Builder{" +
                    "DeviceId=" + deviceId +
                    ", DeviceTypeId=" + deviceTypeId +
                    '}';
        }
    }



} // Main
