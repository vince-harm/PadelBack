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

    private static final List<ReservationDTO> RESERVATIONS = new ArrayList<>();
    static {
        RESERVATIONS.add(new ReservationDTO(
                UUID.randomUUID(),
                "Court 1",
                LocalDate.of(2026, 3, 28),
                "10:00",
                "Vincent"
        ));
        RESERVATIONS.add(new ReservationDTO(
                UUID.randomUUID(),
                "Court 2",
                LocalDate.of(2026, 3, 28),
                "14:30",
                "Christelle"
        ));
    }

    @GetMapping(produces = "application/json")
    public List<ReservationDTO> getAll() {
        return RESERVATIONS;
    }

    @GetMapping
    public List<ReservationDTO> getReservations() {
        return List.of();
    }

    @PostMapping
    public ReservationDTO createReservation(@RequestBody ReservationDTO reservation) {
        return reservation;
    }
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ReservationDTO create(@RequestBody ReservationDTO dto) {
        ReservationDTO newRes = new ReservationDTO(
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
