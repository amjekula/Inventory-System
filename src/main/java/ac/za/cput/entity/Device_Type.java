package ac.za.cput.entity;

public class Device_Type {
    

       
    private final int deviceId;
    private final String deviceDesc;
    private final double deviceSize;
    private final String deviceColor;


    private Device_Type(Builder builder){
     
        this.deviceId = builder.deviceId;
        this.deviceDesc = builder.deviceDesc;
        this.deviceSize = builder.deviceSize;
        this.deviceColor = builder.deviceColor;
    

    }

    public int getDeviceId(){

    return deviceId;

    }

    public String getDeviceDesc(){

     return deviceDesc;

    }

    public double getDeviceSize(){

    return deviceSize;

    }

    public String getDeviceColor(){

    return deviceColor;

    }

    public static class Builder{

        private int deviceId;
        private String deviceDesc;
        private double deviceSize;
        private String deviceColor;


        public Builder setDeviceId(final int deviceId){

        return this;

        }

        public Builder setDeviceDesc(final String deviceDesc){

        return this;

        }

        public Builder setDeviceSize(final double deviceSize){

        return this;


        }

        public Builder setDeviceColor(final String deviceColor){

        return this;

        }

        public Builder type(Device_Type device_Type){

            this.deviceId = device_Type.deviceId;
            this.deviceDesc = device_Type.deviceDesc;
            this.deviceSize = device_Type.deviceSize;
            this.deviceColor = device_Type.deviceColor;

            return this;

        }

        public Device_Type build(){

         return new Device_Type(this);


        }

    }

    @Override
    public String toString() {
        return "Device_Type{"+
                ", DeviceId=" + deviceId +
                ", DeviceDesc=" + deviceDesc +
                ", DeviceSize=" + deviceSize +
                ", DeviceColor=" + deviceColor +

                '}';
    }
}