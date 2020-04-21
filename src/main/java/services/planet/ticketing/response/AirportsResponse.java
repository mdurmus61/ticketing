package services.planet.ticketing.response;

import services.planet.ticketing.dto.AirportDTO;
import services.planet.ticketing.dto.CompanyDTO;

import java.util.ArrayList;
import java.util.List;

public class AirportsResponse {
    private List<AirportDTO> airports = new ArrayList<>();

    public AirportsResponse() { }

    public AirportsResponse(List<AirportDTO> airports) { this.airports = airports; }

    public List<AirportDTO> getAirports() { return airports; }

    public void setAirports(List<AirportDTO> airports) { this.airports = airports; }
}
