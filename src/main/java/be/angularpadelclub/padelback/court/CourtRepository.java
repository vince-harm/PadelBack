package be.angularpadelclub.padelback.court;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourtRepository extends JpaRepository<CourtEntity, UUID> {
}