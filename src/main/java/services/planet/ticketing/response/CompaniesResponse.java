package services.planet.ticketing.response;

import services.planet.ticketing.dto.CompanyDTO;

import java.util.ArrayList;
import java.util.List;

public class CompaniesResponse {
    private List<CompanyDTO> companies = new ArrayList<>();

    public CompaniesResponse() { }

    public CompaniesResponse(List<CompanyDTO> companies) { this.companies = companies; }

    public List<CompanyDTO> getCompanies() { return companies; }

    public void setCompanies(List<CompanyDTO> companies) { this.companies = companies; }
}
