package services.planet.ticketing.response;

import services.planet.ticketing.dto.UserDTO;

public class UserResponse {
    private UserDTO user;

    public UserResponse() { }

    public UserResponse(UserDTO user) { this.user = user; }

    public UserDTO getUser() { return user; }

    public void setUser(UserDTO user) { this.user = user; }
}
