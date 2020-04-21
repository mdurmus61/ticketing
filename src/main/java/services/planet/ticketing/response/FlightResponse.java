package services.planet.ticketing.response;

import services.planet.ticketing.dto.FlightDTO;

import java.util.List;

public class FlightResponse {
    private FlightDTO flight;

    public FlightResponse() { }

    public FlightResponse(FlightDTO flight) { this.flight = flight; }

    public FlightDTO getFlight() { return flight; }

    public void setFlight(FlightDTO flight) { this.flight = flight; }
}
