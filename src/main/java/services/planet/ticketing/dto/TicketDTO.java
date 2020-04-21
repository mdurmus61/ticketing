package services.planet.ticketing.dto;

import java.math.BigDecimal;

public class TicketDTO {
    private Long id;
    private String ticketNumber;
    private String userName;
    private FlightDTO flight;
    private BigDecimal price;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTicketNumber() { return ticketNumber; }

    public void setTicketNumber(String ticketNumber) { this.ticketNumber = ticketNumber; }

    public String getUserName() { return userName;}

    public void setUserName(String userName) { this.userName = userName; }

    public FlightDTO getFlight() { return flight; }

    public void setFlight(FlightDTO flight) { this.flight = flight; }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }
}
