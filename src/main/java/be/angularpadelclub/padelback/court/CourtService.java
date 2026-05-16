package be.angularpadelclub.padelback.court;

import be.angularpadelclub.padelback.site.SiteEntity;
import be.angularpadelclub.padelback.site.SiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourtService {

    private final CourtRepository courtRepository;
    private final SiteRepository siteRepository;
    private final CourtMapper courtMapper;

    public CourtService(CourtRepository courtRepository,
                        SiteRepository siteRepository,
                        CourtMapper courtMapper) {
        this.courtRepository = courtRepository;
        this.siteRepository = siteRepository;
        this.courtMapper = courtMapper;
    }

    public List<CourtDTO> getAllCourts() {
        return courtRepository.findAll()
                .stream()
                .map(courtMapper::toDTO)
                .toList();
    }

    public CourtDTO getCourtById(UUID id) {
        CourtEntity court = courtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Court not found"));

        return courtMapper.toDTO(court);
    }

    public CourtDTO createCourt(CourtDTO dto) {
        SiteEntity site = siteRepository.findById(dto.siteId())
                .orElseThrow(() -> new RuntimeException("Site not found"));

        CourtEntity court = courtMapper.toEntity(dto, site);
        CourtEntity savedCourt = courtRepository.save(court);

        return courtMapper.toDTO(savedCourt);
    }

    public void deleteCourt(UUID id) {
        courtRepository.deleteById(id);
    }
}