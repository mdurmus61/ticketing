package services.planet.ticketing.entity;

import services.planet.ticketing.dto.AirportCreateDTO;
import services.planet.ticketing.dto.AirportDTO;
import services.planet.ticketing.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Airport extends BaseEntity {

    @NotEmpty
    @Column(unique = true)
    private String name;

    @NotNull
    @ManyToOne
    private City city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public AirportDTO toDTO() {
        AirportDTO dto = new AirportDTO();
        dto.setId(getId());
        dto.setName(getName());
        dto.setCityName(getCity().getName());

        return dto;
    }

}
