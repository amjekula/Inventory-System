package ac.za.cput.entity.equipment;

public class Device {
    private String deviceId;
    private String deviceTypeId;





    public Device(Builder builder){
        this.deviceId = builder.deviceId;
        this.deviceTypeId = builder.deviceTypeId;

    }

    public static class Builder {
        private String deviceId;
        private String deviceTypeId;

        public Builder setDeviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }// Setter

        public Builder setDeviceTypeId(String deviceTypeId) {
            this.deviceTypeId = deviceTypeId;
            return this;
        } // Setter

        public Builder copy(Device device) {
            this.deviceId = device.deviceId;
            this.deviceTypeId = device.deviceTypeId;
            return this;
        }

        public Device build() {
            return new Device(this);

        }
    }
        public String getDeviceId() {
            return deviceId;
        }

        public String getDeviceTypeId() {
            return deviceTypeId;
        }

        @Override
        public String toString() {
            return "Device{" +
                    "device_id=" + deviceId +
                    ", device_type_id=" + deviceTypeId +
                    '}';
        }





} // Main
