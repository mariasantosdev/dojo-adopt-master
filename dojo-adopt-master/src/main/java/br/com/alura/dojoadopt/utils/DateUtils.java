package br.com.alura.dojoadopt.utils;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class DateUtils {
    public static String intervalBetween(Temporal startDate, Temporal endDate) {
        long years = ChronoUnit.YEARS.between(startDate, endDate);

        if (years < 1) {
            return "Tem menos que 1 ano";
        }

        if (years == 1) {
            return "Tem um ano";
        }
        return "Tem " + years + "anos";
    }
}
