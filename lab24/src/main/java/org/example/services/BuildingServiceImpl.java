package org.example.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entities.Building;
import org.example.repository.BuildingRepo;
import org.example.specifications.BuildingSpecification;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional
public class BuildingServiceImpl implements BuildingService {
    private BuildingRepo buildingRepo;

    public BuildingServiceImpl(BuildingRepo buildingRepo) {
        this.buildingRepo = buildingRepo;
    }
    @Override
    public Long createBuilding(Building building) {
        buildingRepo.save(building);
        return building.getId();
    }

    @Override
    public List<Building> getBuildings() {
//        log.info("get all buildings");
        return buildingRepo.findAll();
    }

    @Override
    public void deleteBuilding(Long id) {

//        log.info("delete building by id: {}", id);
        buildingRepo.deleteById(id);
    }

    @Override
    public List<Building> getBuildingsSortedBy(String attributeName) {
//        log.info("get all buildings sorted by attribute: {}", attributeName);
        Sort sort = Sort.by(Sort.Direction.ASC, attributeName);
        return buildingRepo.findAll(BuildingSpecification.sortBy(attributeName), sort);
    }
}
