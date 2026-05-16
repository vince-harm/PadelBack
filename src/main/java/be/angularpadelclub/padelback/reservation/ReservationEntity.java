package be.angularpadelclub.padelback.reservation;
import jakarta.persistence.Entity;
import java.util.UUID;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
@Entity
@Table(name="reservations")

public class ReservationEntity {

    @Id
    private UUID id;
    private String courtName;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String playerMatricule;
    private LocalDateTime createdAt;
}
