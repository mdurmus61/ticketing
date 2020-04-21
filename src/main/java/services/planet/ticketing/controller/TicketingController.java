package services.planet.ticketing.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import services.planet.ticketing.request.*;
import services.planet.ticketing.response.*;
import services.planet.ticketing.service.TicketingService;

import java.time.OffsetDateTime;

@RestController
public class TicketingController {
    private final TicketingService ticketingService;

    public TicketingController(TicketingService ticketingService) {
        this.ticketingService = ticketingService;
    }

    @RequestMapping("/")
    public String welcome() {
        return "Welcome to Ticketing Server";
    }

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse createUser(@RequestBody CreateUserRequest request){
        return new UserResponse(ticketingService.createUser(request.getCreateDTO()));
    }

    @PostMapping(value = "/city", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CityResponse createCity(@RequestBody CreateCityRequest request){
       return new CityResponse(ticketingService.createCity(request.getCreateDTO()));
    }

    @PostMapping(value = "/company", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CompanyResponse createCompany(@RequestBody CreateCompanyRequest request){
        return new CompanyResponse(ticketingService.createCompany(request.getCreateDTO()));
    }

    @PostMapping(value = "/airport", consumes = MediaType.APPLICATION_JSON_VALUE)
    public AirportResponse createAirport(@RequestBody CreateAirportRequest request) {
        return new AirportResponse(ticketingService.createAirport(request.getCreateDTO()));
    }

    @PostMapping(value = "/route", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RouteResponse createRoute(@RequestBody CreateRouteRequest request) {
       return new RouteResponse(ticketingService.createRoute(request.getCreateDTO()));
    }

    @PostMapping(value = "/flight", consumes = MediaType.APPLICATION_JSON_VALUE)
    public FlightResponse createFlight(@RequestBody CreateFlightRequest request) {
        return new FlightResponse(ticketingService.createFlight(request.getCreateDTO()));
    }

    @PostMapping(value = "/buy/ticket", consumes = MediaType.APPLICATION_JSON_VALUE)
    public TicketResponse buyTicket(@RequestBody CreateTicketRequest request) {
        return new TicketResponse(ticketingService.buyTicket(request.getCreateDTO()));
    }

    @GetMapping(value = "/users/all", consumes = MediaType.ALL_VALUE)
    public UsersResponse getAllUsers(){
        return new UsersResponse(ticketingService.getAllUsers());
    }

    @GetMapping(value = "/user/{USER_NAME}", consumes = MediaType.ALL_VALUE)
    public UserResponse getUserByUserName(@PathVariable("USER_NAME") String userName){
        return new UserResponse(ticketingService.getUserByUserName(userName));
    }

    @GetMapping(value = "/cities/all", consumes = MediaType.ALL_VALUE)
    public CitiesResponse getAllCities(){
        return new CitiesResponse(ticketingService.getAllCities());
    }

    @GetMapping(value = "/city/{NAME}", consumes = MediaType.ALL_VALUE)
    public CityResponse getCityByName(@PathVariable("NAME") String name){
        return new CityResponse(ticketingService.getCityByName(name));
    }

    @GetMapping(value = "/companies/all", consumes = MediaType.ALL_VALUE)
    public CompaniesResponse getAllCompanies(){
        return new CompaniesResponse(ticketingService.getAllCompanies());
    }

    @GetMapping(value = "/company/{COMPANY_NAME}", consumes = MediaType.ALL_VALUE)
    public CompanyResponse getCompanyByName(@PathVariable("COMPANY_NAME") String companyName){
        return new CompanyResponse(ticketingService.getCompanyByName(companyName));
    }

    @GetMapping(value = "/airports/all", consumes = MediaType.ALL_VALUE)
    public AirportsResponse getAllAirports(){
        return new AirportsResponse(ticketingService.getAllAirports());
    }

    @GetMapping(value = "/airport/{AIRPORT_NAME}", consumes = MediaType.ALL_VALUE)
    public AirportResponse getAirportByName(@PathVariable("AIRPORT_NAME") String airportName){
        return new AirportResponse(ticketingService.getAirportByName(airportName));
    }

    @GetMapping(value = "/routes/all", consumes = MediaType.ALL_VALUE)
    public RoutesResponse getAllRoutes(){
        return new RoutesResponse(ticketingService.getAllRoutes());
    }

    @GetMapping(value = "/routes/by/params", consumes = MediaType.ALL_VALUE)
    public RoutesResponse getRoutesByParameters(@RequestParam(required = false) String departureName, @RequestParam(required = false) String arrivalName){
        return new RoutesResponse(ticketingService.getRoutesByParameters(departureName, arrivalName));
    }

    @GetMapping(value = "/flights/by/params", consumes = MediaType.ALL_VALUE)
    public FlightsResponse getFlightsByParameters(@RequestParam(required = false) String companyName, @RequestParam(required = false) String departureName, @RequestParam(required = false) String arrivalName,
                                                @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime departureTime,
                                                @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime arrivalTime){
        return new FlightsResponse(ticketingService.getFlightsByParameters(companyName, departureName, arrivalName, departureTime, arrivalTime));
    }

    @GetMapping(value = "/ticket/{TICKET_NUMBER}", consumes = MediaType.ALL_VALUE)
    public TicketResponse getTicketByTicketNumber(@PathVariable("TICKET_NUMBER") String ticketNumber){
       return new TicketResponse(ticketingService.getTicketByTicketNumber(ticketNumber));
    }

    @DeleteMapping(value = "/ticket/delete/{TICKET_NUMBER}", consumes = MediaType.ALL_VALUE)
    public TicketOperationResponse deleteTicket(@PathVariable("TICKET_NUMBER") String ticketNumber){
        return new TicketOperationResponse(ticketingService.deleteTicket(ticketNumber));
    }

}
