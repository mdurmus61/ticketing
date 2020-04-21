package services.planet.ticketing.entity;

import services.planet.ticketing.dto.UserDTO;
import services.planet.ticketing.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class User extends BaseEntity {

    @NotNull
    @Column(unique = true)
    private String userName;

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public UserDTO toDTO() {
        UserDTO dto = new UserDTO();
        dto.setId(getId());
        dto.setUserName(getUserName());

        return dto;
    }
}
