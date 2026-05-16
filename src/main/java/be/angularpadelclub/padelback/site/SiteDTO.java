package be.angularpadelclub.padelback.site;

import java.time.LocalTime;
import java.util.UUID;

public record SiteDTO(
        UUID id,
        String name,
        String city,
        LocalTime openingTime,
        LocalTime closingTime,
        boolean active
) {
}
