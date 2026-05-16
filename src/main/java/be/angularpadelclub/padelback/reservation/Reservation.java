package be.angularpadelclub.padelback.reservation;

import java.time.LocalDate;
import java.util.UUID;

public record Reservation(
        UUID uuid,
        String courtName,
        LocalDate date,
        String timeSlot,
        String playerName
) {}
