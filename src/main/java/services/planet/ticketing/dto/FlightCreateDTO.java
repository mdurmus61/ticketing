package services.planet.ticketing.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class FlightCreateDTO {
    private String companyName;
    private String departureName;
    private String arrivalName;
    private OffsetDateTime departureTime;
    private OffsetDateTime arrivalTime;
    private Integer maxCapacity;
    private BigDecimal defaultPrice;

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

    public Integer getMaxCapacity() { return maxCapacity; }

    public void setMaxCapacity(Integer maxCapacity) { this.maxCapacity = maxCapacity; }

    public BigDecimal getDefaultPrice() { return defaultPrice; }

    public void setDefaultPrice(BigDecimal defaultPrice) { this.defaultPrice = defaultPrice; }
}
