package services.planet.ticketing.dto;

import java.time.OffsetDateTime;

public class TicketCreateDTO {
    private String userName;
    private String companyName;
    private String departureName;
    private String arrivalName;
    private OffsetDateTime departureTime;
    private OffsetDateTime arrivalTime;

    public String getUserName() { return userName;}

    public void setUserName(String userName) { this.userName = userName; }

    public String getCompanyName() { return companyName; }

    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getDepartureName() { return departureName; }

    public void setDepartureName(String departureName) { this.departureName = departureName; }

    public String getArrivalName() { return arrivalName; }

    public void setArrivalName(String arrivalName) { this.arrivalName = arrivalName; }

    public OffsetDateTime getDepartureTime() { return departureTime; }

    public void setDepartureTime(OffsetDateTime departureTime) { this.departureTime = departureTime; }

    public OffsetDateTime getArrivalTime() { return arrivalTime; }

    public void setArrivalTime(OffsetDateTime arrivalTime) { this.arrivalTime = arrivalTime; }
}
