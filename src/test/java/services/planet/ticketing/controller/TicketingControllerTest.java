package services.planet.ticketing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import services.planet.ticketing.dto.*;
import services.planet.ticketing.request.*;
import services.planet.ticketing.service.TicketingService;

public class TicketingControllerTest {

    private TicketingController ticketingController;
    private MockMvc mockMvc;
    private ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Before
    public void setup() {
        TicketingService ticketingService = Mockito.mock(TicketingService.class);

        ticketingController = new TicketingController(ticketingService);
        mockMvc = MockMvcBuilders.standaloneSetup(ticketingController).build();
    }

    @Test
    public void welcome() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/" ))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void create_user() throws Exception {
        CreateUserRequest request = new CreateUserRequest();
        request.setCreateDTO(new UserCreateDTO());
        String json = ow.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    public void create_city() throws Exception {
        CreateCityRequest request = new CreateCityRequest();
        request.setCreateDTO(new CityCreateDTO());
        String json = ow.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/city")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    public void create_company() throws Exception {
        CreateCompanyRequest request = new CreateCompanyRequest();
        request.setCreateDTO(new CompanyCreateDTO());
        String json = ow.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/company")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    public void create_airport() throws Exception {
        CreateAirportRequest request = new CreateAirportRequest();
        request.setCreateDTO(new AirportCreateDTO());
        String json = ow.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/airport")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    public void create_route() throws Exception {
        CreateRouteRequest request = new CreateRouteRequest();
        request.setCreateDTO(new RouteCreateDTO());
        String json = ow.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/route")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    public void create_flight() throws Exception {
        CreateFlightRequest request = new CreateFlightRequest();
        request.setCreateDTO(new FlightCreateDTO());
        String json = ow.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/flight")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    public void buy_ticket() throws Exception {
        CreateTicketRequest request = new CreateTicketRequest();
        request.setCreateDTO(new TicketCreateDTO());
        String json = ow.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/buy/ticket")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

    }

    @Test
    public void get_all_users() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/all" ))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void get_user_by_name() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/test" ))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void get_all_cities() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cities/all" ))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void get_city_by_name() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/city/test" ))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void get_all_companies() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/companies/all" ))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void get_company_by_name() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/company/test" ))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void get_all_airports() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/airports/all" ))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void get_airport_by_name() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/airport/test" ))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void get_all_routes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/routes/all" ))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void get_routes_by_params() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/routes/by/params" ))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void get_flights_by_params() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/flights/by/params" ))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void get_ticket_by_number() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ticket/test" ))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void delete_ticket_by_number() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/ticket/delete/test" ))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
