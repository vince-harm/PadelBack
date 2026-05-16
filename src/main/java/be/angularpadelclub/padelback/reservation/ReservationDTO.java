package be.angularpadelclub.padelback.reservation;

import java.time.LocalDate;
import java.util.UUID;

public record ReservationDTO(
        UUID uuid,
        String courtName,
        LocalDate date,
        String timeSlot,
        String playerName
) {}
