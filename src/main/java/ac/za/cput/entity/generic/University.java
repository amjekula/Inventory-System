package ac.za.cput.entity.generic;

/*
 *  @author: Sherwin Adams
 *  Desc: Entity for University
 */

import ac.za.cput.entity.user.ControlClerk;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class University implements Serializable {

    @Id
    private String universityId;
    private String name;
    private String address;

    protected University(){}

    @OneToMany(mappedBy="university", cascade = CascadeType.ALL)
    Set<ControlClerk> controlClerks = new HashSet<ControlClerk>();

    private University(Builder builder) {
        this.universityId = builder.universityId;
        this.name = builder.name;
        this.address = builder.address;
    }

    public String getUniversityId() {
        return universityId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public static class Builder {
        private String universityId;
        private String name;
        private String address;

        public Builder setUniversityId(String universityId) {
            this.universityId = universityId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(String address) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return universityId.equals(that.universityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(universityId);
    }
}
