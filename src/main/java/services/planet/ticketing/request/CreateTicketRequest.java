package services.planet.ticketing.request;

import services.planet.ticketing.dto.TicketCreateDTO;

public class CreateTicketRequest {
    private TicketCreateDTO createDTO;

    public TicketCreateDTO getCreateDTO() { return createDTO; }

    public void setCreateDTO(TicketCreateDTO createDTO) { this.createDTO = createDTO; }
}
