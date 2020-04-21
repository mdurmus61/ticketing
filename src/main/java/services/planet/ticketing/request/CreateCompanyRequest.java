package services.planet.ticketing.request;

import services.planet.ticketing.dto.CompanyCreateDTO;

public class CreateCompanyRequest {
    private CompanyCreateDTO createDTO;

    public CompanyCreateDTO getCreateDTO() { return createDTO; }

    public void setCreateDTO(CompanyCreateDTO createDTO) { this.createDTO = createDTO; }
}
