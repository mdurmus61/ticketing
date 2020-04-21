package services.planet.ticketing.response;

import services.planet.ticketing.dto.CityDTO;

import java.util.ArrayList;
import java.util.List;

public class CitiesResponse {
    private List<CityDTO> cities = new ArrayList<>();

    public CitiesResponse() { }

    public CitiesResponse(List<CityDTO> cities) { this.cities = cities; }

    public List<CityDTO> getCities() { return cities; }

    public void setCities(List<CityDTO> cities) { this.cities = cities; }
}
