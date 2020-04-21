package services.planet.ticketing.entity;

import services.planet.ticketing.dto.CityDTO;
import services.planet.ticketing.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class City extends BaseEntity {

    @NotEmpty
    @Column(unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityDTO toDTO() {
        CityDTO dto = new CityDTO();
        dto.setId(getId());
        dto.setName(getName());

        return dto;
    }
}
