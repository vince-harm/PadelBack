package be.angularpadelclub.padelback.reservation;

import java.time.LocalDate;
import java.util.UUID;

public record reservation(
        UUID uuid,
        String courtName,
        LocalDate date,
        String timeSlot
) {}
