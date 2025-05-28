package com.java.challenge.discount;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DiscountService {

    public double calculateDiscount(Order order) {
        double total = order.total();

        if (order.getCustomer().isPremium()) {
            return total * 0.15;
        } else if (total > 1_000) {
            return total * 0.10;
        } else if (LocalDate.now().getDayOfWeek()
                == DayOfWeek.MONDAY) {
            return total * 0.05;
        }
        return 0;
    }
}

