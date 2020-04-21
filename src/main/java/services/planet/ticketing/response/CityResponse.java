package services.planet.ticketing.response;


import services.planet.ticketing.dto.CityDTO;

public class CityResponse {
    private CityDTO city;

    public CityResponse() { }

    public CityResponse(CityDTO city) { this.city = city; }

    public CityDTO getCity() { return city; }

    public void setCity(CityDTO city) { this.city = city; }
}
