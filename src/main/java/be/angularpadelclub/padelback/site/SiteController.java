package be.angularpadelclub.padelback.site;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sites")
public class SiteController {

    private final SiteService siteService;

    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @GetMapping
    public List<SiteDTO> getAllSites() {
        return siteService.getAllSites();
    }

    @GetMapping("/{id}")
    public SiteDTO getSiteById(@PathVariable UUID id) {
        return siteService.getSiteById(id);
    }

    @PostMapping
    public SiteDTO createSite(@RequestBody SiteDTO dto) {
        return siteService.createSite(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteSite(@PathVariable UUID id) {
        siteService.deleteSite(id);
    }
}
