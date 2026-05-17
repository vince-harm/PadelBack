//Vérifie que JPA sauve vraiment en DB H2.
package be.angularpadelclub.padelback;

import be.angularpadelclub.padelback.court.CourtEntity;
import be.angularpadelclub.padelback.court.CourtRepository;
import be.angularpadelclub.padelback.reservation.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private CourtRepository courtRepository;

    @Mock
    private ReservationMapper reservationMapper;

    @InjectMocks
    private ReservationService reservationService;

    @Test
    void shouldSetCreatedAtWhenAddingReservation() {
        UUID courtId = UUID.randomUUID();

        CourtEntity court = new CourtEntity();
        court.setId(courtId);

        ReservationDTO dto = new ReservationDTO(
                null,
                courtId,
                null,
                LocalDate.of(2026, 6, 20),
                LocalTime.of(18, 0),
                LocalTime.of(19, 30),
                "G1234"
        );

        ReservationEntity entity = new ReservationEntity();

        when(courtRepository.findById(courtId)).thenReturn(Optional.of(court));
        when(reservationRepository.existsByCourtAndDateAndStartTimeLessThanAndEndTimeGreaterThan(
                court,
                dto.date(),
                dto.endTime(),
                dto.startTime()
        )).thenReturn(false);
        when(reservationMapper.toEntity(dto, court)).thenReturn(entity);

        reservationService.addReservation(dto);

        assertNotNull(entity.getCreatedAt());
        verify(reservationRepository).save(entity);
    }
}