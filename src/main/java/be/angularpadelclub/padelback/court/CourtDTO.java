package be.angularpadelclub.padelback.court;

import java.util.UUID;

public record CourtDTO(
        UUID id,
        String name,
        String type,
        UUID siteId
) {
}