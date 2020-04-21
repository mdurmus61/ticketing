package services.planet.ticketing.response;

import services.planet.ticketing.dto.CompanyDTO;
import services.planet.ticketing.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UsersResponse {
    private List<UserDTO> users = new ArrayList<>();

    public UsersResponse() { }

    public UsersResponse(List<UserDTO> users) { this.users = users; }

    public List<UserDTO> getUsers() { return users; }

    public void setUsers(List<UserDTO> users) { this.users = users; }
}
