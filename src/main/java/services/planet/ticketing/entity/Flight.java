package services.planet.ticketing.entity;

import services.planet.ticketing.dto.FlightDTO;
import services.planet.ticketing.entity.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
public class Flight extends BaseEntity {

    @NotNull
    @ManyToOne
    private Company company;

    @NotNull
    @ManyToOne
    private Route route;

    @NotNull
    private OffsetDateTime departureTime;

    @NotNull
    private OffsetDateTime arrivalTime;

    @NotNull
    private Integer maxCapacity;

    @NotNull
    private Integer capacity;

    @NotNull
    @Digits(integer = 16, fraction = 2)
    private BigDecimal defaultPrice;

    @NotNull
    @Digits(integer = 16, fraction = 2)
    private BigDecimal price;

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public OffsetDateTime getDepartureTime() { return departureTime; }

    public void setDepartureTime(OffsetDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public OffsetDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(OffsetDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) { this.maxCapacity = maxCapacity; }

    public Integer getCapacity() { return capacity; }

    public void setCapacity(Integer capacity) { this.capacity = capacity; }

    public BigDecimal getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(BigDecimal defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public Company getCompany() { return company; }

    public void setCompany(Company company) { this.company = company; }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public FlightDTO toDTO() {
        FlightDTO dto = new FlightDTO();
        dto.setId(getId());
        dto.setCompanyName(getCompany().getName());
        dto.setArrivalName(getRoute().getArrival().getName());
        dto.setDepartureName(getRoute().getDeparture().getName());
        dto.setDepartureTime(getDepartureTime());
        dto.setArrivalTime(getArrivalTime());
        dto.setPrice(getPrice());
        dto.setCapacity(getCapacity());
        dto.setMaxCapacity(getMaxCapacity());
        dto.setDefaultPrice(getDefaultPrice());

        return dto;
    }
}
