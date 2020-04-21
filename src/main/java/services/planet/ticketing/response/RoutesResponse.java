package services.planet.ticketing.response;

import services.planet.ticketing.dto.CompanyDTO;
import services.planet.ticketing.dto.RouteDTO;

import java.util.ArrayList;
import java.util.List;

public class RoutesResponse {
    private List<RouteDTO> routes = new ArrayList<>();

    public RoutesResponse() { }

    public RoutesResponse(List<RouteDTO> routes) { this.routes = routes; }

    public List<RouteDTO> getRoutes() { return routes; }

    public void setRoutes(List<RouteDTO> routes) { this.routes = routes; }
}
