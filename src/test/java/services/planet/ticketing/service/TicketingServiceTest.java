package services.planet.ticketing.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import services.planet.ticketing.dto.*;
import services.planet.ticketing.exception.TicketingException;
import services.planet.ticketing.repository.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DataJpaTest(includeFilters = @ComponentScan.Filter(classes = {Service.class}))
public class TicketingServiceTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private FlightRepository companyFlightRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private TicketRepository ticketRepository;

    private TicketingService ticketingService;


    @Before
    public void setup() {
        ticketingService = new TicketingService(userRepository, airportRepository, cityRepository, companyRepository, routeRepository, companyFlightRepository, ticketRepository);
    }

    @Test
    public void simple_test() {
        Assert.assertEquals(1, 1);
        Assert.assertTrue(true);
    }

    @Test
    public void create_user() {
        UserCreateDTO dto = new UserCreateDTO();
        dto.setUserName("mdurmus");
        UserDTO result = ticketingService.createUser(dto);

        Assert.assertNotNull(result);
    }

    @Test
    public void create_company() {
        CompanyCreateDTO dto = new CompanyCreateDTO();
        dto.setName("THY");
        CompanyDTO result = ticketingService.createCompany(dto);

        Assert.assertNotNull(result);
    }

    @Test
    public void create_city() {
        CityCreateDTO dto = new CityCreateDTO();
        dto.setName("İstanbul");
        CityDTO result = ticketingService.createCity(dto);

        Assert.assertNotNull(result);
    }

    @Test
    public void create_airport() {
        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        AirportCreateDTO dto = new AirportCreateDTO();
        dto.setCityName("İstanbul");
        dto.setName("Sabiha Gökçen HL");
        AirportDTO result = ticketingService.createAirport(dto);

        Assert.assertNotNull(result);
    }

    @Test(expected = TicketingException.class)
    public void create_airport_exception() {

        AirportCreateDTO dto = new AirportCreateDTO();
        dto.setCityName("İstanbul");
        dto.setName("Sabiha Gökçen HL");
        ticketingService.createAirport(dto);
    }

    @Test
    public void create_route() {
        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        cityCreateDTO.setName("Ankara");
        ticketingService.createCity(cityCreateDTO);

        AirportCreateDTO airportCreateDTO = new AirportCreateDTO();
        airportCreateDTO.setCityName("İstanbul");
        airportCreateDTO.setName("Sabiha Gökçen HL");
        ticketingService.createAirport(airportCreateDTO);

        airportCreateDTO.setCityName("Ankara");
        airportCreateDTO.setName("Esenboğa HL");
        ticketingService.createAirport(airportCreateDTO);

        RouteCreateDTO dto = new RouteCreateDTO();
        dto.setDepartureName("Sabiha Gökçen HL");
        dto.setArrivalName("Esenboğa HL");
        RouteDTO result = ticketingService.createRoute(dto);

        Assert.assertNotNull(result);
    }

    @Test(expected = TicketingException.class)
    public void create_route_exception_1() {
        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        cityCreateDTO.setName("Ankara");
        ticketingService.createCity(cityCreateDTO);

        RouteCreateDTO dto = new RouteCreateDTO();
        dto.setDepartureName("Sabiha Gökçen HL");
        dto.setArrivalName("Esenboğa HL");
        ticketingService.createRoute(dto);
    }

    @Test(expected = TicketingException.class)
    public void create_route_exception_2() {
        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        cityCreateDTO.setName("Ankara");
        ticketingService.createCity(cityCreateDTO);

        AirportCreateDTO airportCreateDTO = new AirportCreateDTO();
        airportCreateDTO.setCityName("İstanbul");
        airportCreateDTO.setName("Sabiha Gökçen HL");
        ticketingService.createAirport(airportCreateDTO);

        RouteCreateDTO dto = new RouteCreateDTO();
        dto.setDepartureName("Sabiha Gökçen HL");
        dto.setArrivalName("Esenboğa HL");
        ticketingService.createRoute(dto);
    }

    @Test
    public void create_flight() {
        CompanyCreateDTO companyCreateDTO = new CompanyCreateDTO();
        companyCreateDTO.setName("THY");
        ticketingService.createCompany(companyCreateDTO);

        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        cityCreateDTO.setName("Ankara");
        ticketingService.createCity(cityCreateDTO);

        AirportCreateDTO airportCreateDTO = new AirportCreateDTO();
        airportCreateDTO.setCityName("İstanbul");
        airportCreateDTO.setName("Sabiha Gökçen HL");
        ticketingService.createAirport(airportCreateDTO);

        airportCreateDTO.setCityName("Ankara");
        airportCreateDTO.setName("Esenboğa HL");
        ticketingService.createAirport(airportCreateDTO);

        RouteCreateDTO routeCreateDTO = new RouteCreateDTO();
        routeCreateDTO.setDepartureName("Sabiha Gökçen HL");
        routeCreateDTO.setArrivalName("Esenboğa HL");
        ticketingService.createRoute(routeCreateDTO);

        FlightCreateDTO dto = new FlightCreateDTO();
        dto.setDepartureTime(OffsetDateTime.now());
        dto.setArrivalTime(OffsetDateTime.now());
        dto.setArrivalName("Esenboğa HL");
        dto.setDepartureName("Sabiha Gökçen HL");
        dto.setCompanyName("THY");
        dto.setDefaultPrice(BigDecimal.valueOf(10000, 2));
        dto.setMaxCapacity(100);
        FlightDTO result = ticketingService.createFlight(dto);

        Assert.assertNotNull(result);
    }

    @Test(expected = TicketingException.class)
    public void create_flight_exception_1() {
        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        cityCreateDTO.setName("Ankara");
        ticketingService.createCity(cityCreateDTO);

        AirportCreateDTO airportCreateDTO = new AirportCreateDTO();
        airportCreateDTO.setCityName("İstanbul");
        airportCreateDTO.setName("Sabiha Gökçen HL");
        ticketingService.createAirport(airportCreateDTO);

        airportCreateDTO.setCityName("Ankara");
        airportCreateDTO.setName("Esenboğa HL");
        ticketingService.createAirport(airportCreateDTO);

        RouteCreateDTO routeCreateDTO = new RouteCreateDTO();
        routeCreateDTO.setDepartureName("Sabiha Gökçen HL");
        routeCreateDTO.setArrivalName("Esenboğa HL");
        ticketingService.createRoute(routeCreateDTO);

        FlightCreateDTO dto = new FlightCreateDTO();
        dto.setDepartureTime(OffsetDateTime.now());
        dto.setArrivalTime(OffsetDateTime.now());
        dto.setArrivalName("Esenboğa HL");
        dto.setDepartureName("Sabiha Gökçen HL");
        dto.setCompanyName("THY");
        dto.setDefaultPrice(BigDecimal.valueOf(10000, 2));
        dto.setMaxCapacity(100);
        ticketingService.createFlight(dto);
    }

    @Test(expected = TicketingException.class)
    public void create_flight_exception_2() {
        CompanyCreateDTO companyCreateDTO = new CompanyCreateDTO();
        companyCreateDTO.setName("THY");
        ticketingService.createCompany(companyCreateDTO);

        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        cityCreateDTO.setName("Ankara");
        ticketingService.createCity(cityCreateDTO);

        AirportCreateDTO airportCreateDTO = new AirportCreateDTO();
        airportCreateDTO.setCityName("İstanbul");
        airportCreateDTO.setName("Sabiha Gökçen HL");
        ticketingService.createAirport(airportCreateDTO);

        airportCreateDTO.setCityName("Ankara");
        airportCreateDTO.setName("Esenboğa HL");
        ticketingService.createAirport(airportCreateDTO);

        FlightCreateDTO dto = new FlightCreateDTO();
        dto.setDepartureTime(OffsetDateTime.now());
        dto.setArrivalTime(OffsetDateTime.now());
        dto.setArrivalName("Esenboğa HL");
        dto.setDepartureName("Sabiha Gökçen HL");
        dto.setCompanyName("THY");
        dto.setDefaultPrice(BigDecimal.valueOf(10000, 2));
        dto.setMaxCapacity(100);
        ticketingService.createFlight(dto);
    }

    @Test
    public void buy_ticket() {
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUserName("mdurmus");
        ticketingService.createUser(userCreateDTO);

        CompanyCreateDTO companyCreateDTO = new CompanyCreateDTO();
        companyCreateDTO.setName("THY");
        ticketingService.createCompany(companyCreateDTO);

        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        cityCreateDTO.setName("Ankara");
        ticketingService.createCity(cityCreateDTO);

        AirportCreateDTO airportCreateDTO = new AirportCreateDTO();
        airportCreateDTO.setCityName("İstanbul");
        airportCreateDTO.setName("Sabiha Gökçen HL");
        ticketingService.createAirport(airportCreateDTO);

        airportCreateDTO.setCityName("Ankara");
        airportCreateDTO.setName("Esenboğa HL");
        ticketingService.createAirport(airportCreateDTO);

        RouteCreateDTO routeCreateDTO = new RouteCreateDTO();
        routeCreateDTO.setDepartureName("Sabiha Gökçen HL");
        routeCreateDTO.setArrivalName("Esenboğa HL");
        ticketingService.createRoute(routeCreateDTO);

        FlightCreateDTO flightCreateDTO = new FlightCreateDTO();
        flightCreateDTO.setDepartureTime(OffsetDateTime.of(2020,4, 18, 20, 0, 0, 0, ZoneOffset.UTC));
        flightCreateDTO.setArrivalTime(OffsetDateTime.of(2020,4, 18, 22, 0, 0, 0, ZoneOffset.UTC));
        flightCreateDTO.setArrivalName("Esenboğa HL");
        flightCreateDTO.setDepartureName("Sabiha Gökçen HL");
        flightCreateDTO.setCompanyName("THY");
        flightCreateDTO.setDefaultPrice(BigDecimal.valueOf(10000, 2));
        flightCreateDTO.setMaxCapacity(100);
        ticketingService.createFlight(flightCreateDTO);

        TicketCreateDTO dto = new TicketCreateDTO();
        dto.setUserName("mdurmus");
        dto.setArrivalName("Esenboğa HL");
        dto.setDepartureName("Sabiha Gökçen HL");
        dto.setCompanyName("THY");
        dto.setDepartureTime(OffsetDateTime.of(2020,4, 18, 20, 0, 0, 0, ZoneOffset.UTC));
        dto.setArrivalTime(OffsetDateTime.of(2020,4, 18, 22, 0, 0, 0, ZoneOffset.UTC));

        TicketDTO result = ticketingService.buyTicket(dto);

        Assert.assertNotNull(result);
        Assert.assertEquals("THY_1", result.getTicketNumber());
    }

    @Test(expected = TicketingException.class)
    public void buy_ticket_exception_1() {
        TicketCreateDTO dto = new TicketCreateDTO();
        dto.setUserName("mdurmus");
        dto.setArrivalName("Esenboğa HL");
        dto.setDepartureName("Sabiha Gökçen HL");
        dto.setCompanyName("THY");
        dto.setDepartureTime(OffsetDateTime.of(2020,4, 18, 20, 0, 0, 0, ZoneOffset.UTC));
        dto.setArrivalTime(OffsetDateTime.of(2020,4, 18, 22, 0, 0, 0, ZoneOffset.UTC));
        ticketingService.buyTicket(dto);
    }

    @Test(expected = TicketingException.class)
    public void buy_ticket_exception_2() {
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUserName("mdurmus");
        ticketingService.createUser(userCreateDTO);

        CompanyCreateDTO companyCreateDTO = new CompanyCreateDTO();
        companyCreateDTO.setName("THY");
        ticketingService.createCompany(companyCreateDTO);

        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        cityCreateDTO.setName("Ankara");
        ticketingService.createCity(cityCreateDTO);

        AirportCreateDTO airportCreateDTO = new AirportCreateDTO();
        airportCreateDTO.setCityName("İstanbul");
        airportCreateDTO.setName("Sabiha Gökçen HL");
        ticketingService.createAirport(airportCreateDTO);

        airportCreateDTO.setCityName("Ankara");
        airportCreateDTO.setName("Esenboğa HL");
        ticketingService.createAirport(airportCreateDTO);

        RouteCreateDTO routeCreateDTO = new RouteCreateDTO();
        routeCreateDTO.setDepartureName("Sabiha Gökçen HL");
        routeCreateDTO.setArrivalName("Esenboğa HL");
        ticketingService.createRoute(routeCreateDTO);

        TicketCreateDTO dto = new TicketCreateDTO();
        dto.setUserName("mdurmus");
        dto.setArrivalName("Esenboğa HL");
        dto.setDepartureName("Sabiha Gökçen HL");
        dto.setCompanyName("THY");
        dto.setDepartureTime(OffsetDateTime.of(2020,4, 18, 20, 0, 0, 0, ZoneOffset.UTC));
        dto.setArrivalTime(OffsetDateTime.of(2020,4, 18, 22, 0, 0, 0, ZoneOffset.UTC));

        ticketingService.buyTicket(dto);
    }

    @Test(expected = TicketingException.class)
    public void buy_ticket_exception_3() {
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUserName("mdurmus");
        ticketingService.createUser(userCreateDTO);

        CompanyCreateDTO companyCreateDTO = new CompanyCreateDTO();
        companyCreateDTO.setName("THY");
        ticketingService.createCompany(companyCreateDTO);

        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        cityCreateDTO.setName("Ankara");
        ticketingService.createCity(cityCreateDTO);

        AirportCreateDTO airportCreateDTO = new AirportCreateDTO();
        airportCreateDTO.setCityName("İstanbul");
        airportCreateDTO.setName("Sabiha Gökçen HL");
        ticketingService.createAirport(airportCreateDTO);

        airportCreateDTO.setCityName("Ankara");
        airportCreateDTO.setName("Esenboğa HL");
        ticketingService.createAirport(airportCreateDTO);

        RouteCreateDTO routeCreateDTO = new RouteCreateDTO();
        routeCreateDTO.setDepartureName("Sabiha Gökçen HL");
        routeCreateDTO.setArrivalName("Esenboğa HL");
        ticketingService.createRoute(routeCreateDTO);

        FlightCreateDTO flightCreateDTO = new FlightCreateDTO();
        flightCreateDTO.setDepartureTime(OffsetDateTime.of(2020,4, 18, 20, 0, 0, 0, ZoneOffset.UTC));
        flightCreateDTO.setArrivalTime(OffsetDateTime.of(2020,4, 18, 22, 0, 0, 0, ZoneOffset.UTC));
        flightCreateDTO.setArrivalName("Esenboğa HL");
        flightCreateDTO.setDepartureName("Sabiha Gökçen HL");
        flightCreateDTO.setCompanyName("THY");
        flightCreateDTO.setDefaultPrice(BigDecimal.valueOf(10000, 2));
        flightCreateDTO.setMaxCapacity(0);
        ticketingService.createFlight(flightCreateDTO);

        TicketCreateDTO dto = new TicketCreateDTO();
        dto.setUserName("mdurmus");
        dto.setArrivalName("Esenboğa HL");
        dto.setDepartureName("Sabiha Gökçen HL");
        dto.setCompanyName("THY");
        dto.setDepartureTime(OffsetDateTime.of(2020,4, 18, 20, 0, 0, 0, ZoneOffset.UTC));
        dto.setArrivalTime(OffsetDateTime.of(2020,4, 18, 22, 0, 0, 0, ZoneOffset.UTC));

        ticketingService.buyTicket(dto);
    }

    @Test
    public void get_all_users() {
        List<UserDTO> users = ticketingService.getAllUsers();
        Assert.assertEquals(0, users.size());

        UserCreateDTO dto = new UserCreateDTO();
        dto.setUserName("mdurmus");
        ticketingService.createUser(dto);

        users = ticketingService.getAllUsers();
        Assert.assertEquals(1, users.size());
    }

    @Test
    public void get_user_by_name() {
        UserDTO user = ticketingService.getUserByUserName("mdurmus");
        Assert.assertNull(user);

        UserCreateDTO dto = new UserCreateDTO();
        dto.setUserName("mdurmus");
        ticketingService.createUser(dto);

        user = ticketingService.getUserByUserName("mdurmus");
        Assert.assertNotNull(user);
    }

    @Test
    public void get_all_cities() {
        List<CityDTO> cities = ticketingService.getAllCities();
        Assert.assertEquals(0, cities.size());

        CityCreateDTO dto = new CityCreateDTO();
        dto.setName("İstanbul");
        ticketingService.createCity(dto);

        cities = ticketingService.getAllCities();
        Assert.assertEquals(1, cities.size());
    }

    @Test
    public void get_city_by_name() {
        CityDTO city = ticketingService.getCityByName("İstanbul");
        Assert.assertNull(city);

        CityCreateDTO dto = new CityCreateDTO();
        dto.setName("İstanbul");
        ticketingService.createCity(dto);

        city = ticketingService.getCityByName("İstanbul");
        Assert.assertNotNull(city);
    }

    @Test
    public void get_all_companies() {
        List<CompanyDTO> companies = ticketingService.getAllCompanies();
        Assert.assertEquals(0, companies.size());

        CompanyCreateDTO dto = new CompanyCreateDTO();
        dto.setName("THY");
        ticketingService.createCompany(dto);

        companies = ticketingService.getAllCompanies();
        Assert.assertEquals(1, companies.size());
    }

    @Test
    public void get_company_by_name() {
        CompanyDTO company = ticketingService.getCompanyByName("THY");
        Assert.assertNull(company);

        CompanyCreateDTO dto = new CompanyCreateDTO();
        dto.setName("THY");
        ticketingService.createCompany(dto);

        company = ticketingService.getCompanyByName("THY");
        Assert.assertNotNull(company);
    }

    @Test
    public void get_all_airports() {
        List<AirportDTO> airports = ticketingService.getAllAirports();
        Assert.assertEquals(0, airports.size());

        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        AirportCreateDTO dto = new AirportCreateDTO();
        dto.setCityName("İstanbul");
        dto.setName("Sabiha Gökçen HL");
        ticketingService.createAirport(dto);

        airports = ticketingService.getAllAirports();
        Assert.assertEquals(1, airports.size());
    }

    @Test
    public void get_airport_by_name() {
        AirportDTO airport = ticketingService.getAirportByName("Sabiha Gökçen HL");
        Assert.assertNull(airport);

        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        AirportCreateDTO dto = new AirportCreateDTO();
        dto.setCityName("İstanbul");
        dto.setName("Sabiha Gökçen HL");
        ticketingService.createAirport(dto);

        airport = ticketingService.getAirportByName("Sabiha Gökçen HL");
        Assert.assertNotNull(airport);
    }

    @Test
    public void get_all_routes() {
        List<RouteDTO> routes = ticketingService.getAllRoutes();
        Assert.assertEquals(0, routes.size());

        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        cityCreateDTO.setName("Ankara");
        ticketingService.createCity(cityCreateDTO);

        AirportCreateDTO airportCreateDTO = new AirportCreateDTO();
        airportCreateDTO.setCityName("İstanbul");
        airportCreateDTO.setName("Sabiha Gökçen HL");
        ticketingService.createAirport(airportCreateDTO);

        airportCreateDTO.setCityName("Ankara");
        airportCreateDTO.setName("Esenboğa HL");
        ticketingService.createAirport(airportCreateDTO);

        RouteCreateDTO dto = new RouteCreateDTO();
        dto.setDepartureName("Sabiha Gökçen HL");
        dto.setArrivalName("Esenboğa HL");
        ticketingService.createRoute(dto);

        routes = ticketingService.getAllRoutes();

        Assert.assertEquals(1, routes.size());
    }

    @Test
    public void get_all_routes_by_params() {
        List<RouteDTO> routes = ticketingService.getRoutesByParameters(null, null);
        Assert.assertEquals(0, routes.size());

        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        cityCreateDTO.setName("Ankara");
        ticketingService.createCity(cityCreateDTO);

        AirportCreateDTO airportCreateDTO = new AirportCreateDTO();
        airportCreateDTO.setCityName("İstanbul");
        airportCreateDTO.setName("Sabiha Gökçen HL");
        ticketingService.createAirport(airportCreateDTO);

        airportCreateDTO.setCityName("Ankara");
        airportCreateDTO.setName("Esenboğa HL");
        ticketingService.createAirport(airportCreateDTO);

        RouteCreateDTO dto = new RouteCreateDTO();
        dto.setDepartureName("Sabiha Gökçen HL");
        dto.setArrivalName("Esenboğa HL");
        ticketingService.createRoute(dto);

        routes = ticketingService.getRoutesByParameters("", "");
        Assert.assertEquals(0, routes.size());

        routes = ticketingService.getRoutesByParameters("Sabiha Gökçen HL", null);
        Assert.assertEquals(1, routes.size());

        routes = ticketingService.getRoutesByParameters(null, "Esenboğa HL");
        Assert.assertEquals(1, routes.size());

        routes = ticketingService.getRoutesByParameters("Sabiha Gökçen HL", "Esenboğa HL");
        Assert.assertEquals(1, routes.size());
    }

    @Test
    public void get_all_flights_by_params() {
        List<FlightDTO> flights = ticketingService.getFlightsByParameters(null, null, null, null, null);
        Assert.assertEquals(0, flights.size());

        CompanyCreateDTO companyCreateDTO = new CompanyCreateDTO();
        companyCreateDTO.setName("THY");
        ticketingService.createCompany(companyCreateDTO);

        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        cityCreateDTO.setName("Ankara");
        ticketingService.createCity(cityCreateDTO);

        AirportCreateDTO airportCreateDTO = new AirportCreateDTO();
        airportCreateDTO.setCityName("İstanbul");
        airportCreateDTO.setName("Sabiha Gökçen HL");
        ticketingService.createAirport(airportCreateDTO);

        airportCreateDTO.setCityName("Ankara");
        airportCreateDTO.setName("Esenboğa HL");
        ticketingService.createAirport(airportCreateDTO);

        RouteCreateDTO routeCreateDTO = new RouteCreateDTO();
        routeCreateDTO.setDepartureName("Sabiha Gökçen HL");
        routeCreateDTO.setArrivalName("Esenboğa HL");
        ticketingService.createRoute(routeCreateDTO);

        FlightCreateDTO dto = new FlightCreateDTO();
        dto.setDepartureTime(OffsetDateTime.now());
        dto.setArrivalTime(OffsetDateTime.now());
        dto.setArrivalName("Esenboğa HL");
        dto.setDepartureName("Sabiha Gökçen HL");
        dto.setCompanyName("THY");
        dto.setDefaultPrice(BigDecimal.valueOf(10000, 2));
        dto.setMaxCapacity(100);
        ticketingService.createFlight(dto);

        flights = ticketingService.getFlightsByParameters(null, null, null, null, null);
        Assert.assertEquals(1, flights.size());

        flights = ticketingService.getFlightsByParameters("THY", null, null, null, null);
        Assert.assertEquals(1, flights.size());
    }

    @Test
    public void get_ticket_by_ticket_number() {
        TicketDTO ticket = ticketingService.getTicketByTicketNumber("THY - 1");
        Assert.assertNull(ticket);

        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUserName("mdurmus");
        ticketingService.createUser(userCreateDTO);

        CompanyCreateDTO companyCreateDTO = new CompanyCreateDTO();
        companyCreateDTO.setName("THY");
        ticketingService.createCompany(companyCreateDTO);

        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        cityCreateDTO.setName("Ankara");
        ticketingService.createCity(cityCreateDTO);

        AirportCreateDTO airportCreateDTO = new AirportCreateDTO();
        airportCreateDTO.setCityName("İstanbul");
        airportCreateDTO.setName("Sabiha Gökçen HL");
        ticketingService.createAirport(airportCreateDTO);

        airportCreateDTO.setCityName("Ankara");
        airportCreateDTO.setName("Esenboğa HL");
        ticketingService.createAirport(airportCreateDTO);

        RouteCreateDTO routeCreateDTO = new RouteCreateDTO();
        routeCreateDTO.setDepartureName("Sabiha Gökçen HL");
        routeCreateDTO.setArrivalName("Esenboğa HL");
        ticketingService.createRoute(routeCreateDTO);

        FlightCreateDTO flightCreateDTO = new FlightCreateDTO();
        flightCreateDTO.setDepartureTime(OffsetDateTime.of(2020,4, 18, 20, 0, 0, 0, ZoneOffset.UTC));
        flightCreateDTO.setArrivalTime(OffsetDateTime.of(2020,4, 18, 22, 0, 0, 0, ZoneOffset.UTC));
        flightCreateDTO.setArrivalName("Esenboğa HL");
        flightCreateDTO.setDepartureName("Sabiha Gökçen HL");
        flightCreateDTO.setCompanyName("THY");
        flightCreateDTO.setDefaultPrice(BigDecimal.valueOf(10000, 2));
        flightCreateDTO.setMaxCapacity(100);
        ticketingService.createFlight(flightCreateDTO);

        TicketCreateDTO dto = new TicketCreateDTO();
        dto.setUserName("mdurmus");
        dto.setArrivalName("Esenboğa HL");
        dto.setDepartureName("Sabiha Gökçen HL");
        dto.setCompanyName("THY");
        dto.setDepartureTime(OffsetDateTime.of(2020,4, 18, 20, 0, 0, 0, ZoneOffset.UTC));
        dto.setArrivalTime(OffsetDateTime.of(2020,4, 18, 22, 0, 0, 0, ZoneOffset.UTC));

        String retValue = ticketingService.buyTicket(dto).getTicketNumber();

        ticket = ticketingService.getTicketByTicketNumber(retValue);
        Assert.assertNotNull(ticket);
    }

    @Test
    public void delete_ticket() {
        UserCreateDTO userCreateDTO = new UserCreateDTO();
        userCreateDTO.setUserName("mdurmus");
        ticketingService.createUser(userCreateDTO);

        CompanyCreateDTO companyCreateDTO = new CompanyCreateDTO();
        companyCreateDTO.setName("THY");
        ticketingService.createCompany(companyCreateDTO);

        CityCreateDTO cityCreateDTO = new CityCreateDTO();
        cityCreateDTO.setName("İstanbul");
        ticketingService.createCity(cityCreateDTO);

        cityCreateDTO.setName("Ankara");
        ticketingService.createCity(cityCreateDTO);

        AirportCreateDTO airportCreateDTO = new AirportCreateDTO();
        airportCreateDTO.setCityName("İstanbul");
        airportCreateDTO.setName("Sabiha Gökçen HL");
        ticketingService.createAirport(airportCreateDTO);

        airportCreateDTO.setCityName("Ankara");
        airportCreateDTO.setName("Esenboğa HL");
        ticketingService.createAirport(airportCreateDTO);

        RouteCreateDTO routeCreateDTO = new RouteCreateDTO();
        routeCreateDTO.setDepartureName("Sabiha Gökçen HL");
        routeCreateDTO.setArrivalName("Esenboğa HL");
        ticketingService.createRoute(routeCreateDTO);

        FlightCreateDTO flightCreateDTO = new FlightCreateDTO();
        flightCreateDTO.setDepartureTime(OffsetDateTime.of(2020,4, 18, 20, 0, 0, 0, ZoneOffset.UTC));
        flightCreateDTO.setArrivalTime(OffsetDateTime.of(2020,4, 18, 22, 0, 0, 0, ZoneOffset.UTC));
        flightCreateDTO.setArrivalName("Esenboğa HL");
        flightCreateDTO.setDepartureName("Sabiha Gökçen HL");
        flightCreateDTO.setCompanyName("THY");
        flightCreateDTO.setDefaultPrice(BigDecimal.valueOf(10000, 2));
        flightCreateDTO.setMaxCapacity(100);
        ticketingService.createFlight(flightCreateDTO);

        TicketCreateDTO dto = new TicketCreateDTO();
        dto.setUserName("mdurmus");
        dto.setArrivalName("Esenboğa HL");
        dto.setDepartureName("Sabiha Gökçen HL");
        dto.setCompanyName("THY");
        dto.setDepartureTime(OffsetDateTime.of(2020,4, 18, 20, 0, 0, 0, ZoneOffset.UTC));
        dto.setArrivalTime(OffsetDateTime.of(2020,4, 18, 22, 0, 0, 0, ZoneOffset.UTC));

        String retValue = ticketingService.buyTicket(dto).getTicketNumber();

        String ticket = ticketingService.deleteTicket(retValue);
        Assert.assertNotNull(ticket);
    }

    @Test(expected = TicketingException.class)
    public void delete_ticket_exception() {
       ticketingService.deleteTicket("test");
    }
}
