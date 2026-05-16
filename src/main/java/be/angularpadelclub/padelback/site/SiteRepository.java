package be.angularpadelclub.padelback.site;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SiteRepository extends JpaRepository<SiteEntity, UUID> {
}
