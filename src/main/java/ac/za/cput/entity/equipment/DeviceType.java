package ac.za.cput.entity.equipment;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

//JodiSmit
@Entity
public class DeviceType implements Serializable {

   @Id
    private String deviceTypeId;
    private String deviceDescription;
    private double size;
    private String color;

    protected DeviceType(){}
    public DeviceType(Builder builder){

        this.deviceTypeId = builder.deviceTypeId;
        this.deviceDescription = builder.deviceDescription;
        this.size = builder.size;
        this.color = builder.color;


    }

    public String getDeviceTypeId(){ return deviceTypeId; }

    public String getDeviceDescription(){ return deviceDescription; }

    public double getSize(){ return size; }

    public String getColor(){ return color; }

    public static class Builder{

        private String deviceTypeId;
        private String deviceDescription;
        private double size;
        private String color;


        public Builder setDeviceTypeId(final String deviceTypeId){
            this.deviceTypeId = deviceTypeId;
            return this;

        }

        public Builder setDeviceDescription(final String deviceDescription){
           this.deviceDescription = deviceDescription;
            return this;

        }

        public Builder setSize(final double size){
             this.size = size;
            return this;


        }

        public Builder setColor(final String color){
            this.color = color;
            return this;

        }

        public Builder copy(DeviceType deviceType){

            this.deviceTypeId = deviceType.deviceTypeId;
            this.deviceDescription = deviceType.deviceDescription;
            this.size = deviceType.size;
            this.color = deviceType.color;

            return this;

        }

        public DeviceType build(){

            return new DeviceType(this);


        }

    }

    @Override
    public String toString() {
        return "DeviceType{"+
                ", DeviceTypeId=" + deviceTypeId +
                ", DeviceDescription=" + deviceDescription +
                ", Size=" + size +
                ", Color=" + color +

                '}';
    }
}
