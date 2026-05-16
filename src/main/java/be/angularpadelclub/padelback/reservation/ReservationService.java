package be.angularpadelclub.padelback.reservation;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Service

public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationService(
            ReservationRepository reservationRepository,
            ReservationMapper reservationMapper
    ) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    public List<ReservationDTO> findAll() {
        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::toDTO)
                .toList();
    }

    public ReservationDTO create(ReservationDTO dto) {
        ReservationEntity entity = reservationMapper.toEntity(dto);
        entity.setCreatedAt(LocalDateTime.now());

        ReservationEntity saved = reservationRepository.save(entity);

        return reservationMapper.toDTO(saved);
    }

    public void deleteById(UUID id) {
        reservationRepository.deleteById(id);
    }
}
