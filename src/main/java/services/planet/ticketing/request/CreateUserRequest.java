package services.planet.ticketing.request;

import services.planet.ticketing.dto.UserCreateDTO;

public class CreateUserRequest {
    private UserCreateDTO createDTO;

    public UserCreateDTO getCreateDTO() { return createDTO; }

    public void setCreateDTO(UserCreateDTO createDTO) { this.createDTO = createDTO; }
}
