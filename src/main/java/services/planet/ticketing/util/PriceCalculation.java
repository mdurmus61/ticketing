package services.planet.ticketing.util;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class PriceCalculation {
    public BigDecimal calculatePrice(BigDecimal price, Integer capacity, Integer maxCapacity) {
        if(isCapacityIncrease(capacity, maxCapacity)) {
            return price.multiply(BigDecimal.valueOf(11,1)).setScale(2, RoundingMode.HALF_UP);
        }
        return price.setScale(2, RoundingMode.HALF_UP);
    }

    private boolean isCapacityIncrease(Integer capacity, Integer maxCapacity) {
        double temp = ((double) capacity / maxCapacity) * 100;
        return (temp % 10) == 0;
    }
}
