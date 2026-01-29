package com.emmlg.persona_api.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {

    public static Integer getAgeFromBirthDate(LocalDate birthDate) {
        if (birthDate == null) {
            return 0;
        }
        LocalDate currentDate = LocalDate.now();
        int age = currentDate.getYear() - birthDate.getYear();

        // Verificar si el cumpleaños ya ocurrió este año
        if (currentDate.getMonthValue() < birthDate.getMonthValue() ||
            (currentDate.getMonthValue() == birthDate.getMonthValue() && currentDate.getDayOfMonth() < birthDate.getDayOfMonth())) {
            age--;
        }
        return age;
    }
}
