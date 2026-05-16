package be.angularpadelclub.padelback.site;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SiteService {

    private final SiteRepository siteRepository;
    private final SiteMapper siteMapper;

    public SiteService(SiteRepository siteRepository, SiteMapper siteMapper) {
        this.siteRepository = siteRepository;
        this.siteMapper = siteMapper;
    }

    public List<SiteDTO> getAllSites() {
        return siteMapper.toDTOList(siteRepository.findAll());
    }

    public SiteDTO getSiteById(UUID id) {
        SiteEntity site = siteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Site not found"));

        return siteMapper.toDTO(site);
    }

    public SiteDTO createSite(SiteDTO dto) {
        SiteEntity entity = siteMapper.toEntity(dto);

        entity.setId(null);

        SiteEntity saved = siteRepository.save(entity);

        return siteMapper.toDTO(saved);
    }

    public void deleteSite(UUID id) {
        siteRepository.deleteById(id);
    }
}
