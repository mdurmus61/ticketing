package services.planet.ticketing.response;

import services.planet.ticketing.dto.AirportDTO;
import services.planet.ticketing.dto.TicketDTO;

public class TicketResponse {
    private TicketDTO ticket;

    public TicketResponse() { }

    public TicketResponse(TicketDTO ticket) { this.ticket = ticket; }

    public TicketDTO getTicket() { return ticket; }

    public void setTicket(TicketDTO ticket) { this.ticket = ticket; }
}
