package ru.netology;
import com.github.javafaker.Faker;
import lombok.Data;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class DataGenerator {
    private DataGenerator() {
        }

        public static class Registration {
        private Registration() {}

            public static RegistrationInfo generateByCard(String locale) {
            Faker faker =new Faker(new Locale(locale));
            return new RegistrationInfo(generateCity(),
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber());
        }
    }

    private static Random random = new Random();

    public static String generateCity() {
        String[] cities = new String[]{"Санкт-Петербург", "Москва", "Вологда", "Саратов"};
        return cities[random.nextInt(cities.length)];
    }

    public static String generateDate(int days, int month) {
        return LocalDate.now().plusDays(3 + days).plusDays(random.nextInt(month))
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

}
