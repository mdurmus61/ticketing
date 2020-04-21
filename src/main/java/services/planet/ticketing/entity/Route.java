package services.planet.ticketing.entity;

import services.planet.ticketing.dto.RouteDTO;
import services.planet.ticketing.entity.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "departure", "arrival" }))
public class Route extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name="departure")
    private Airport departure;

    @NotNull
    @ManyToOne
    @JoinColumn(name="arrival")
    private Airport arrival;

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    public void setArrival(Airport arrival) {
        this.arrival = arrival;
    }

    public RouteDTO toDTO() {
        RouteDTO dto = new RouteDTO();
        dto.setId(getId());
        dto.setArrivalName(getArrival().getName());
        dto.setArrivalCity(getArrival().getCity().getName());
        dto.setDepartureName(getDeparture().getName());
        dto.setDepartureCity(getDeparture().getCity().getName());

        return dto;
    }
}
