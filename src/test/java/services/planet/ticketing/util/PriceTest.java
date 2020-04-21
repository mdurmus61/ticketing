package services.planet.ticketing.util;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PriceTest {
    private PriceCalculation priceCalculation;

    @Before
    public void setup() {
        priceCalculation = new PriceCalculation();
    }

    @Test
    public void test_1() {
        BigDecimal retValue = priceCalculation.calculatePrice(BigDecimal.TEN, 1, 10);
        assertEquals(BigDecimal.valueOf(1100, 2 ), retValue);
    }

    @Test
    public void test_2() {
        BigDecimal retValue = priceCalculation.calculatePrice(BigDecimal.TEN, 1, 100);
        assertEquals(BigDecimal.valueOf(1000, 2 ), retValue);
    }

    @Test
    public void test_3() {
        BigDecimal retValue = priceCalculation.calculatePrice(BigDecimal.TEN, 50, 100);
        assertEquals(BigDecimal.valueOf(1100, 2 ), retValue);
    }
}
