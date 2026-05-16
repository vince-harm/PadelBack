//Vérifie que Entity → DTO fonctionne correctement

package be.angularpadelclub.padelback;

import be.angularpadelclub.padelback.reservation.ReservationDTO;
import be.angularpadelclub.padelback.reservation.ReservationEntity;
import be.angularpadelclub.padelback.reservation.ReservationMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReservationMapperTest {

    private final ReservationMapper mapper = new ReservationMapper();

    @Test
    void shouldMapEntityToDto() {
        ReservationEntity entity = new ReservationEntity();
        entity.setCourtName("Court 1");
        entity.setDate(LocalDate.of(2026, 6, 20));
        entity.setStartTime(LocalTime.of(18, 0));
        entity.setEndTime(LocalTime.of(19, 30));
        entity.setPlayerMatricule("G1234");

        ReservationDTO dto = mapper.toDTO(entity);

        assertEquals("Court 1", dto.courtName());
        assertEquals("G1234", dto.playerMatricule());
    }
}