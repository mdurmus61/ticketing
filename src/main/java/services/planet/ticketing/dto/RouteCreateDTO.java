package services.planet.ticketing.dto;

public class RouteCreateDTO {
    private String departureName;
    private String arrivalName;

    public String getDepartureName() { return departureName; }

    public void setDepartureName(String departureName) { this.departureName = departureName; }

    public String getArrivalName() { return arrivalName; }

    public void setArrivalName(String arrivalName) { this.arrivalName = arrivalName; }
}
