package services.planet.ticketing.dto;

public class AirportDTO {
    private Long id;
    private String name;
    private String cityName;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCityName() { return cityName; }

    public void setCityName(String cityName) { this.cityName = cityName; }
}
