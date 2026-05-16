package be.angularpadelclub.padelback.court;

import be.angularpadelclub.padelback.site.SiteEntity;
import org.springframework.stereotype.Component;

@Component
public class CourtMapper {

    public CourtDTO toDTO(CourtEntity entity) {
        return new CourtDTO(
                entity.getId(),
                entity.getName(),
                entity.getType(),
                entity.getSite().getId()
        );
    }

    public CourtEntity toEntity(CourtDTO dto, SiteEntity site) {
        CourtEntity entity = new CourtEntity();
        entity.setId(dto.id());
        entity.setName(dto.name());
        entity.setType(dto.type());
        entity.setSite(site);
        return entity;
    }
}