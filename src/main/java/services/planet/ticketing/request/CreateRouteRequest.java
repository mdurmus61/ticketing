package services.planet.ticketing.request;

import services.planet.ticketing.dto.RouteCreateDTO;

public class CreateRouteRequest {
    private RouteCreateDTO createDTO;

    public RouteCreateDTO getCreateDTO() { return createDTO; }

    public void setCreateDTO(RouteCreateDTO createDTO) { this.createDTO = createDTO; }
}
