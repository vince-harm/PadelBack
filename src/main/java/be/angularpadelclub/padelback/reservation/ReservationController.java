package be.angularpadelclub.padelback.reservation;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reservations")

public class ReservationController {

    private static final List<Reservation> RESERVATIONS = new ArrayList<>();
    static {
        RESERVATIONS.add(new Reservation(
                UUID.randomUUID(),
                "Court 1",
                LocalDate.of(2026, 3, 28),
                "10:00",
                "Vincent"
        ));
        RESERVATIONS.add(new Reservation(
                UUID.randomUUID(),
                "Court 2",
                LocalDate.of(2026, 3, 28),
                "14:30",
                "Christelle"
        ));
    }

    @GetMapping(produces = "application/json")
    public List<Reservation> getAll() {
        return RESERVATIONS;
    }

    @GetMapping
    public List<Reservation> getReservations() {
        return List.of();
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservation;
    }
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Reservation create(@RequestBody Reservation dto) {
        Reservation newRes = new Reservation(
                UUID.randomUUID(),
                dto.courtName(),
                dto.date(),
                dto.timeSlot(),
                dto.playerName()
        );
        RESERVATIONS.add(newRes);
        return newRes;
    }
}
