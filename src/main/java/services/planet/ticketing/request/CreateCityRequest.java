package services.planet.ticketing.request;

import services.planet.ticketing.dto.CityCreateDTO;

public class CreateCityRequest {
    private CityCreateDTO createDTO;

    public CityCreateDTO getCreateDTO() { return createDTO; }

    public void setCreateDTO(CityCreateDTO createDTO) { this.createDTO = createDTO; }
}
