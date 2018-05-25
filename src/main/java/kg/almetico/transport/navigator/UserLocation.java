package kg.almetico.transport.navigator;

public class UserLocation {
    private Long userId;
    private Double lat;
    private Double lng;

    public UserLocation(Long userId, Double lat, Double lng) {
        this.userId = userId;
        this.lat = lat;
        this.lng = lng;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
