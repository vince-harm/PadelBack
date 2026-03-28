package be.angularpadelclub.padelback.reservation;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservations")


public class ReservationController {

    @GetMapping
    public List<reservation> getReservations() {
        return List.of();
    }
    @PostMapping
    public reservation createReservation(@RequestBody reservation reservation) {
        return reservation;
    }
}
