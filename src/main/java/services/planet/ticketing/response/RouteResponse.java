package services.planet.ticketing.response;

import services.planet.ticketing.dto.RouteDTO;

import java.util.ArrayList;
import java.util.List;

public class RouteResponse {
    private RouteDTO route;

    public RouteResponse() { }

    public RouteResponse(RouteDTO route) { this.route = route; }

    public RouteDTO getRoute() { return route; }

    public void setRoute(RouteDTO route) { this.route = route; }
}
