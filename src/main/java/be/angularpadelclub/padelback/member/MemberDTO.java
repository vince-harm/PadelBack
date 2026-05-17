package be.angularpadelclub.padelback.member;

import java.util.UUID;

public record MemberDTO(
        UUID id,
        String matricule,
        String firstName,
        String lastName,
        MemberType type,
        UUID siteId,
        String siteName
) {
}