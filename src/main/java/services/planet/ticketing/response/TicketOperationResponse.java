package services.planet.ticketing.response;

public class TicketOperationResponse {
    private String ticketNumber;

    public TicketOperationResponse() { }

    public TicketOperationResponse(String ticketNumber) { this.ticketNumber = ticketNumber; }

    public String getTicketNumber() { return ticketNumber; }

    public void setTicketNumber(String ticketNumber) { this.ticketNumber = ticketNumber; }
}
