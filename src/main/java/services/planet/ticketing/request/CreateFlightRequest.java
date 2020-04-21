package services.planet.ticketing.request;

import services.planet.ticketing.dto.FlightCreateDTO;

public class CreateFlightRequest {
    private FlightCreateDTO createDTO;

    public FlightCreateDTO getCreateDTO() { return createDTO; }

    public void setCreateDTO(FlightCreateDTO createDTO) { this.createDTO = createDTO; }
}
