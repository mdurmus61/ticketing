package services.planet.ticketing.dto;

public class RouteDTO {
    private Long id;
    private String departureName;
    private String departureCity;
    private String arrivalName;
    private String arrivalCity;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDepartureName() { return departureName; }

    public void setDepartureName(String departureName) { this.departureName = departureName; }

    public String getArrivalName() { return arrivalName; }

    public void setArrivalName(String arrivalName) { this.arrivalName = arrivalName; }

    public String getDepartureCity() { return departureCity; }

    public void setDepartureCity(String departureCity) { this.departureCity = departureCity; }

    public String getArrivalCity() { return arrivalCity; }

    public void setArrivalCity(String arrivalCity) { this.arrivalCity = arrivalCity; }
}
