package be.angularpadelclub.padelback.reservation;

import be.angularpadelclub.padelback.court.CourtEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservationMapper {

    public ReservationDTO toDTO(ReservationEntity entity) {
        return new ReservationDTO(
                entity.getId(),
                entity.getCourt().getId(),
                entity.getCourt().getName(),
                entity.getDate(),
                entity.getStartTime(),
                entity.getEndTime(),
                entity.getPlayerMatricule()
        );
    }

    public List<ReservationDTO> toDTOList(List<ReservationEntity> entities) {
        return entities.stream()
                .map(this::toDTO)
                .toList();
    }

    public ReservationEntity toEntity(ReservationDTO dto, CourtEntity court) {
        ReservationEntity entity = new ReservationEntity();

        entity.setId(dto.id());
        entity.setCourt(court);
        entity.setDate(dto.date());
        entity.setStartTime(dto.startTime());
        entity.setEndTime(dto.endTime());
        entity.setPlayerMatricule(dto.playerMatricule());

        return entity;
    }
}