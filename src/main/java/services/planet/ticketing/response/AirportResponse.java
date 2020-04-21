package services.planet.ticketing.response;

import services.planet.ticketing.dto.AirportDTO;

public class AirportResponse {
    private AirportDTO airport;

    public AirportResponse() { }

    public AirportResponse(AirportDTO airport) { this.airport = airport; }

    public AirportDTO getAirport() { return airport; }

    public void setAirport(AirportDTO airport) { this.airport = airport; }
}
