package be.angularpadelclub.padelback.reservation;

import be.angularpadelclub.padelback.court.CourtEntity;
import be.angularpadelclub.padelback.court.CourtRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final CourtRepository courtRepository;
    private final ReservationMapper reservationMapper;

    public ReservationService(
            ReservationRepository reservationRepository,
            CourtRepository courtRepository,
            ReservationMapper reservationMapper
    ) {
        this.reservationRepository = reservationRepository;
        this.courtRepository = courtRepository;
        this.reservationMapper = reservationMapper;
    }

    public List<ReservationEntity> findAll() {
        return reservationRepository.findAll();
    }

    public Optional<ReservationEntity> findById(UUID id) {
        return reservationRepository.findById(id);
    }

    public void addReservation(@org.jetbrains.annotations.UnknownNullability ReservationEntity dto) {
        CourtEntity court = courtRepository.findById(dto.courtId())
                .orElseThrow(() -> new RuntimeException("Court not found"));

        ReservationEntity reservation = reservationMapper.toEntity(dto, court);
        reservation.setId(null);
        reservation.setCreatedAt(LocalDateTime.now());

        reservationRepository.save(reservation);
    }

    public void deleteReservation(UUID id) {
        reservationRepository.deleteById(id);
    }
}