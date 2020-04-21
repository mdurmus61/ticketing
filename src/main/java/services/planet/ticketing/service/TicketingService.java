package services.planet.ticketing.service;

import services.planet.ticketing.dto.*;
import services.planet.ticketing.entity.*;
import services.planet.ticketing.exception.TicketingException;
import services.planet.ticketing.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import services.planet.ticketing.util.PriceCalculation;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class TicketingService {
    private final PriceCalculation priceCalculation;
    private final UserRepository userRepository;
    private final AirportRepository airportRepository;
    private final CityRepository cityRepository;
    private final CompanyRepository companyRepository;
    private final RouteRepository routeRepository;
    private final FlightRepository flightRepository;
    private final TicketRepository ticketRepository;

    public TicketingService(UserRepository userRepository, AirportRepository airportRepository, CityRepository cityRepository,
                            CompanyRepository companyRepository, RouteRepository routeRepository, FlightRepository flightRepository,
                            TicketRepository ticketRepository) {
        this.priceCalculation = new PriceCalculation();
        this.userRepository = userRepository;
        this.airportRepository = airportRepository;
        this.cityRepository = cityRepository;
        this.companyRepository = companyRepository;
        this.routeRepository = routeRepository;
        this.flightRepository = flightRepository;
        this.ticketRepository = ticketRepository;
    }

    public UserDTO createUser(UserCreateDTO dto) {
        User user = new User();
        user.setUserName(dto.getUserName());

        return userRepository.save(user).toDTO();
    }

    public CompanyDTO createCompany(CompanyCreateDTO dto) {
        Company company = new Company();
        company.setName(dto.getName());

        return companyRepository.save(company).toDTO();
    }

    public CityDTO createCity(CityCreateDTO dto) {
        City city = new City();
        city.setName(dto.getName());

        return cityRepository.save(city).toDTO();
    }

    public AirportDTO createAirport(AirportCreateDTO dto) {
        Airport airport = new Airport();
        City city = cityRepository.findByName(dto.getCityName());

        if(Objects.isNull(city))
            throw new TicketingException("AIRPORT", "CREATE", "CTIY NOT Found. Name is : " + dto.getCityName());

        airport.setName(dto.getName());
        airport.setCity(city);

        return airportRepository.save(airport).toDTO();
    }

    public RouteDTO createRoute(RouteCreateDTO dto) {
        Route route = new Route();

        Airport departure = airportRepository.findOneByName(dto.getDepartureName());

        if(Objects.isNull(departure))
            throw new TicketingException("ROUTE", "CREATE", "AIRPORT NOT Found. Name is : " + dto.getDepartureName());

        Airport arrival = airportRepository.findOneByName(dto.getArrivalName());

        if(Objects.isNull(arrival))
            throw new TicketingException("ROUTE", "CREATE", "AIRPORT NOT Found. Name is : " + dto.getArrivalName());

        route.setDeparture(departure);
        route.setArrival(arrival);

        return routeRepository.save(route).toDTO();
    }

    public FlightDTO createFlight(FlightCreateDTO dto) {
        Flight flight = new Flight();

        Company company = companyRepository.findByName(dto.getCompanyName());

        if(Objects.isNull(company))
            throw new TicketingException("FLIGHT", "CREATE", "COMPANY NOT Found. Name is : " + dto.getCompanyName());

        Route route = routeRepository.findByDepartureNameAndArrivalName(dto.getDepartureName(), dto.getArrivalName());

        if(Objects.isNull(route))
            throw new TicketingException("FLIGHT", "CREATE", "ROUTE NOT Found. Route is : " + dto.getDepartureName() + " - " + dto.getArrivalName());

        flight.setCapacity(0);
        flight.setMaxCapacity(dto.getMaxCapacity());
        flight.setDefaultPrice(dto.getDefaultPrice());
        flight.setPrice(dto.getDefaultPrice());
        flight.setDepartureTime(dto.getDepartureTime());
        flight.setArrivalTime(dto.getArrivalTime());
        flight.setCompany(company);
        flight.setRoute(route);

        return flightRepository.save(flight).toDTO();
    }

    public TicketDTO buyTicket(TicketCreateDTO dto) {
        User user = userRepository.findByUserName(dto.getUserName());

        if(Objects.isNull(user))
            throw new TicketingException("TICKET", "BUY", "USER NOT Found. User name is : " + dto.getUserName());

        Flight flight = flightRepository.findByCompanyNameAndRouteDepartureNameAndRouteArrivalNameAndDepartureTimeAndArrivalTime(
                dto.getCompanyName(), dto.getDepartureName(), dto.getArrivalName(), dto.getDepartureTime(), dto.getArrivalTime());

        if(Objects.isNull(flight))
            throw new TicketingException("TICKET", "BUY", "FLIGHT NOT Found. Flight infos are : " + dto.getCompanyName() + "-" + dto.getDepartureName() + "-" +
                    dto.getArrivalName() + "-" + dto.getDepartureTime() + "-" +  dto.getArrivalTime());


        if(flight.getCapacity().equals(flight.getMaxCapacity()))
            throw new TicketingException("TICKET", "BUY", "FLIGHT Capacity is full. Flight capacity is : " + flight.getCapacity());

        Ticket ticket = new Ticket();
        ticket.setFlight(flight);
        ticket.setUser(user);
        ticket.setPrice(flight.getPrice());
        ticket.setTicketNumber(flight.getCompany().getName() + "_" + Ticket.getCounter() );
        ticket = ticketRepository.save(ticket);
        Ticket.addCounter();

        flight.setCapacity(flight.getCapacity() + 1);
        flight.setPrice(priceCalculation.calculatePrice(flight.getPrice(), flight.getCapacity(), flight.getMaxCapacity()));
        flightRepository.save(flight);

        return ticket.toDTO();
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> dtoList = new ArrayList<>();
        List<User> users = userRepository.findAll();

        for(User u: users) {
            dtoList.add(u.toDTO());
        }

        return dtoList;
    }

    public UserDTO getUserByUserName(String userName) {
        User user = userRepository.findByUserName(userName);

        return user != null ? user.toDTO() : null;
    }

    public List<CityDTO> getAllCities() {
        List<CityDTO> dtoList = new ArrayList<>();
        List<City> cities = cityRepository.findAll();

        for(City c: cities) {
            dtoList.add(c.toDTO());
        }

        return dtoList;
    }

    public CityDTO getCityByName(String name) {
        City city = cityRepository.findByName(name);

        return city != null ? city.toDTO() : null;
    }

    public List<CompanyDTO> getAllCompanies() {
        List<CompanyDTO> dtoList = new ArrayList<>();
        List<Company> companies = companyRepository.findAll();

        for(Company c: companies) {
            dtoList.add(c.toDTO());
        }

        return dtoList;
    }

    public CompanyDTO getCompanyByName(String name) {
        Company company = companyRepository.findByName(name);

        return company != null ? company.toDTO() : null;
    }

    public List<AirportDTO> getAllAirports() {
        List<AirportDTO> dtoList = new ArrayList<>();
        List<Airport> airports = airportRepository.findAll();

        for(Airport a: airports) {
            dtoList.add(a.toDTO());
        }

        return dtoList;
    }

    public AirportDTO getAirportByName(String name) {
        Airport airport = airportRepository.findOneByName(name);

        return airport != null ? airport.toDTO() : null;
    }

    public List<RouteDTO> getAllRoutes() {
        List<RouteDTO> dtoList = new ArrayList<>();
        List<Route> routes = routeRepository.findAll();

        for(Route r: routes) {
            dtoList.add(r.toDTO());
        }

        return dtoList;
    }

    public List<RouteDTO> getRoutesByParameters(String departureName, String arrivalName) {
        List<RouteDTO> dtoList = new ArrayList<>();
        List<Route> routes = routeRepository.findAllByParams(departureName, arrivalName);

        for(Route r: routes) {
            dtoList.add(r.toDTO());
        }
        return dtoList;
    }

    public List<FlightDTO> getFlightsByParameters(String companyName, String departureName, String arrivalName, OffsetDateTime departureTime, OffsetDateTime arrivalTime) {
        List<FlightDTO> dtoList = new ArrayList<>();
        List<Flight> flights = flightRepository.findAllByParams(companyName, departureName, arrivalName, departureTime, arrivalTime);

        for(Flight f: flights) {
            dtoList.add(f.toDTO());
        }
        return dtoList;
    }

    public TicketDTO getTicketByTicketNumber(String ticketNumber) {
        Ticket ticket = ticketRepository.findByTicketNumber(ticketNumber);

        return ticket != null ? ticket.toDTO() : null;
    }

    public String deleteTicket(String ticketNumber) {
        Ticket ticket = ticketRepository.findByTicketNumber(ticketNumber);

        if(Objects.isNull(ticket))
            throw new TicketingException("TICKET", "DELETE", "TICKET NOT Found. Ticket number is : " + ticketNumber);


        Flight flight = flightRepository.findOneById(ticket.getFlight().getId());
        flight.setCapacity(flight.getCapacity() - 1);
        flight.setPrice(priceCalculation.calculatePrice(flight.getPrice(), flight.getCapacity(), flight.getMaxCapacity()));
        flightRepository.save(flight);

        ticketRepository.delete(ticket);

        return ticket.getTicketNumber();
    }
}
