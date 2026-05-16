//Vérifie que JPA sauve vraiment en DB H2.
package be.angularpadelclub.padelback;

import be.angularpadelclub.padelback.reservation.ReservationEntity;
import be.angularpadelclub.padelback.reservation.ReservationRepository;
import be.angularpadelclub.padelback.reservation.ReservationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    @Test
    void shouldSetCreatedAtWhenAddingReservation() {
        ReservationEntity entity = new ReservationEntity();

        reservationService.addReservation(entity);

        assertNotNull(entity.getCreatedAt());
        verify(reservationRepository).save(entity);
    }
}