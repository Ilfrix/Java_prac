package org.example;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BuildingServiceImpl implements BuildingService{
    private BuildingRepo buildingRepo;
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Override
    public Long createBuilding(Building building) {
        log.info("create building {}", building);
        buildingRepo.save(building);
        return building.getId();
    }

    @Override
    public List<Building> getBuildings() {
        log.info("get all buildings");
        return buildingRepo.findAll();
    }

    @Override
    public void deleteBuilding(Long id) {

        log.info("delete building by id: {}", id);
        buildingRepo.deleteById(id);
    }

    @Override
    public List<Building> getBuildingsSortedBy(String attributeName) {
        log.info("get all buildings sorted by attribute: {}", attributeName);
        Sort sort = Sort.by(Sort.Direction.ASC, attributeName);
        return buildingRepo.findAll(BuildingSpecification.sortBy(attributeName), sort);
    }
}
