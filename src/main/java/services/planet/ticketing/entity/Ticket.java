package services.planet.ticketing.entity;

import services.planet.ticketing.dto.TicketDTO;
import services.planet.ticketing.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Ticket extends BaseEntity {

    public static Integer counter = 1;

    @NotEmpty
    @Column(unique = true)
    private String ticketNumber;

    @NotNull
    @ManyToOne
    private User user;

    @NotNull
    @ManyToOne
    private Flight flight;

    @NotNull
    @Digits(integer = 16, fraction = 2)
    private BigDecimal price;

    public String getTicketNumber() { return ticketNumber; }

    public void setTicketNumber(String ticketNumber) { this.ticketNumber = ticketNumber; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public BigDecimal getPrice() { return price; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public TicketDTO toDTO() {
        TicketDTO dto = new TicketDTO();
        dto.setId(getId());
        dto.setTicketNumber(getTicketNumber());
        dto.setUserName(getUser().getUserName());
        dto.setFlight(getFlight().toDTO());
        dto.setPrice(getPrice());

        return dto;
    }

    public static Integer getCounter() {
        return counter;
    }

    public static void addCounter() {
        Ticket.counter ++;
    }
}
