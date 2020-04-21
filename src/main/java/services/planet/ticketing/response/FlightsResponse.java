package services.planet.ticketing.response;

import services.planet.ticketing.dto.FlightDTO;

import java.util.List;

public class FlightsResponse {
    private List<FlightDTO> flights;

    public FlightsResponse() { }

    public FlightsResponse(List<FlightDTO> flights) { this.flights = flights; }

    public List<FlightDTO> getFlights() { return flights; }

    public void setFlights(List<FlightDTO> flights) { this.flights = flights; }
}
