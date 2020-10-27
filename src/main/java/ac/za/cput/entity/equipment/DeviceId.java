package ac.za.cput.entity.equipment;

import java.io.Serializable;
import java.util.Objects;

public class DeviceId implements Serializable {

    private String deviceId,deviceTypeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceId deviceId1 = (DeviceId) o;
        return deviceId.equals(deviceId1.deviceId) &&
                deviceTypeId.equals(deviceId1.deviceTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId, deviceTypeId);
    }
}
