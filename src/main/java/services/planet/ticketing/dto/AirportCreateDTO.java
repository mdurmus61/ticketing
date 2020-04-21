package services.planet.ticketing.dto;

public class AirportCreateDTO {
    private String name;
    private String cityName;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCityName() { return cityName; }

    public void setCityName(String cityName) { this.cityName = cityName; }
}
