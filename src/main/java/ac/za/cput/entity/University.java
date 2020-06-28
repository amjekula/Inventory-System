package ac.za.cput.entity;

public class University {
    private final int universityId;
    private final String name;
    private final String address;

    private University(Builder builder) {
        this.universityId = builder.universityId;
        this.name = builder.name;
        this.address = builder.address;
    }

    public int getUniversityId() {
        return universityId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {
        private int universityId;
        private String name;
        private String address;

        public Builder setUniversityId(final int universityId) {
            this.universityId = universityId;
            return this;
        }

        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(final String address) {
            this.address = address;
            return this;
        }

        public Builder copy(University university) {
            this.universityId = university.universityId;
            this.name = university.name;
            this.address = university.address;
            return this;
        }

        public University build() {
            return new University(this);
        }
    }

    @Override
    public String toString() {
        return "University{" +
                "universityId=" + universityId +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
