package be.angularpadelclub.padelback.reservation;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reservations")

public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<ReservationDTO> findAll() {
        return reservationService.findAll();
    }

    @PostMapping
    public ReservationDTO create(@RequestBody ReservationDTO dto) {
        return reservationService.create(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        reservationService.deleteById(id);
    }
}
