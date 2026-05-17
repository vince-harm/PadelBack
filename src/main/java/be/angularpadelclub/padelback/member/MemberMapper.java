package be.angularpadelclub.padelback.member;

import be.angularpadelclub.padelback.site.SiteEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberMapper {

    public MemberDTO toDTO(MemberEntity entity) {
        return new MemberDTO(
                entity.getId(),
                entity.getMatricule(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getType(),
                entity.getSite() != null ? entity.getSite().getId() : null,
                entity.getSite() != null ? entity.getSite().getName() : null
        );
    }

    public MemberEntity toEntity(MemberDTO dto, SiteEntity site) {
        MemberEntity entity = new MemberEntity();

        entity.setId(dto.id());
        entity.setMatricule(dto.matricule());
        entity.setFirstName(dto.firstName());
        entity.setLastName(dto.lastName());
        entity.setType(dto.type());
        entity.setSite(site);

        return entity;
    }

    public List<MemberDTO> toDTOList(List<MemberEntity> entities) {
        return entities.stream()
                .map(this::toDTO)
                .toList();
    }
}