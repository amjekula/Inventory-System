package ac.za.cput.entity;

public class DeviceType {


    private final int device_Type_Id;
    private final String device_Description;
    private final double size;
    private final String color;


    private DeviceType(Builder builder){

        this.device_Type_Id = builder.device_Type_Id;
        this.device_Description = builder.device_Description;
        this.size = builder.size;
        this.color = builder.color;


    }

    public int getDevice_Type_Id(){

        return device_Type_Id;

    }

    public String getDevice_Description(){

        return device_Description;

    }

    public double getSize(){

        return size;

    }

    public String getColor(){

        return color;

    }

    public static class Builder{

        private int device_Type_Id;
        private String device_Description;
        private double size;
        private String color;


        public Builder setDevice_Type_Id(final int device_Type_Id){

            return this;

        }

        public Builder setDevice_Description(final String device_Description){

            return this;

        }

        public Builder setSize(final double size){

            return this;


        }

        public Builder setColor(final String color){

            return this;

        }

        public Builder type(DeviceType deviceType){

            this.device_Type_Id = deviceType.device_Type_Id;
            this.device_Description = deviceType.device_Description;
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
                ", Device_Type_Id=" + device_Type_Id +
                ", Device_Description=" + device_Description +
                ", Size=" + size +
                ", Color=" + color +

                '}';
    }
}
