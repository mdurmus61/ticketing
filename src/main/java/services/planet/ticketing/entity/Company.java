package services.planet.ticketing.entity;

import services.planet.ticketing.dto.CompanyDTO;
import services.planet.ticketing.entity.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Company extends BaseEntity {

    @NotEmpty
    @Column(unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyDTO toDTO() {
        CompanyDTO dto = new CompanyDTO();
        dto.setId(getId());
        dto.setName(getName());

        return dto;
    }
}
