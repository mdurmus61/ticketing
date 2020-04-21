package services.planet.ticketing.util;

import org.junit.Test;

public class GetterSetterTest {
    @Test
    public void test_services_planet_ticketing_dto() {
        TestUtil.validatePackage("services.planet.ticketing.dto");
    }

    @Test
    public void test_services_planet_ticketing_entity() {
        TestUtil.validatePackage("services.planet.ticketing.entity");
    }

    @Test
    public void test_services_planet_ticketing_entity_base() {
        TestUtil.validatePackage("services.planet.ticketing.entity.base");
    }

    @Test
    public void test_services_planet_ticketing_request() {
        TestUtil.validatePackage("services.planet.ticketing.request");
    }

    @Test
    public void test_services_planet_ticketing_response() {
        TestUtil.validatePackage("services.planet.ticketing.response");
    }

    @Test
    public void test_services_planet_ticketing_exception() {
        TestUtil.validatePackage("services.planet.ticketing.exception");
    }
}
