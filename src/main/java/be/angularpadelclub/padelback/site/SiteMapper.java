package be.angularpadelclub.padelback.site;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SiteMapper {

    public SiteDTO toDTO(SiteEntity entity) {
        return new SiteDTO(
                entity.getId(),
                entity.getName(),
                entity.getCity(),
                entity.getOpeningTime(),
                entity.getClosingTime(),
                entity.isActive()
        );
    }

    public List<SiteDTO> toDTOList(List<SiteEntity> entities) {
        return entities.stream()
                .map(this::toDTO)
                .toList();
    }

    public SiteEntity toEntity(SiteDTO dto) {
        SiteEntity entity = new SiteEntity();

        entity.setId(dto.id());
        entity.setName(dto.name());
        entity.setCity(dto.city());
        entity.setOpeningTime(dto.openingTime());
        entity.setClosingTime(dto.closingTime());
        entity.setActive(dto.active());

        return entity;
    }
}
