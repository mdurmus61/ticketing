package services.planet.ticketing.response;

import services.planet.ticketing.dto.CompanyDTO;

import java.util.ArrayList;
import java.util.List;

public class CompanyResponse {
    private CompanyDTO company;

    public CompanyResponse() { }

    public CompanyResponse(CompanyDTO company) { this.company = company; }

    public CompanyDTO getCompany() { return company; }

    public void setCompany(CompanyDTO company) { this.company = company; }
}
