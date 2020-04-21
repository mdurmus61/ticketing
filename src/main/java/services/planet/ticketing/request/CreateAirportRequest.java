package services.planet.ticketing.request;

import services.planet.ticketing.dto.AirportCreateDTO;

public class CreateAirportRequest {
    private AirportCreateDTO createDTO;

    public AirportCreateDTO getCreateDTO() { return createDTO; }

    public void setCreateDTO(AirportCreateDTO createDTO) { this.createDTO = createDTO; }
}
