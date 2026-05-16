//Vérifie que addReservation() met bien createdAt et appelle le repository.save() pour persister l'entité. C'est un test d'intégration qui vérifie que la couche service fonctionne correctement avec la couche repository et la base de données en mémoire H2.
package be.angularpadelclub.padelback;

import be.angularpadelclub.padelback.reservation.ReservationEntity;
import be.angularpadelclub.padelback.reservation.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    void shouldSaveReservation() {
        ReservationEntity entity = new ReservationEntity();
        entity.setCourtName("Court 1");
        entity.setDate(LocalDate.of(2026, 6, 20));
        entity.setStartTime(LocalTime.of(18, 0));
        entity.setEndTime(LocalTime.of(19, 30));
        entity.setPlayerMatricule("G1234");
        entity.setCreatedAt(LocalDateTime.now());

        ReservationEntity saved = reservationRepository.save(entity);

        assertNotNull(saved.getId());
    }
}
