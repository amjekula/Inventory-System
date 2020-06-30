package ac.za.cput.entity;

public class DeviceType {


    private final int deviceId;
    private final String deviceDesc;
    private final double deviceSize;
    private final String deviceColor;


    private DeviceType(Builder builder){

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

        public Builder type(DeviceType deviceType){

            this.deviceId = deviceType.deviceId;
            this.deviceDesc = deviceType.deviceDesc;
            this.deviceSize = deviceType.deviceSize;
            this.deviceColor = deviceType.deviceColor;

            return this;

        }

        public DeviceType build(){

            return new DeviceType(this);


        }

    }

    @Override
    public String toString() {
        return "DeviceType{"+
                ", DeviceId=" + deviceId +
                ", DeviceDesc=" + deviceDesc +
                ", DeviceSize=" + deviceSize +
                ", DeviceColor=" + deviceColor +

                '}';
    }
}
