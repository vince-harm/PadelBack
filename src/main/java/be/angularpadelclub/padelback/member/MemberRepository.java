package be.angularpadelclub.padelback.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<MemberEntity, UUID> {

    Optional<MemberEntity> findByMatricule(String matricule);

    boolean existsByMatricule(String matricule);
}