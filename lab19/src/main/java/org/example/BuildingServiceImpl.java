package org.example;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuildingServiceImpl implements BuildingService{
    private BuildingRepo buildingRepo;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @Override
    public Long createBuilding(Building building) {
        LOGGER.info("create building");
        buildingRepo.save(building);
        return building.getId();
    }

    @Override
    public List<Building> getBuildings() {
        LOGGER.info("get all buildings");
        return buildingRepo.findAll();
    }

    @Override
    public void deleteBuilding(Long id) {

        LOGGER.info("delete building by id");
        buildingRepo.deleteById(id);
    }

    @Override
    public List<Building> getBuildingsSortedBy(String attributeName) {
        LOGGER.info("get all buildings sorted by attribute: ");
        Sort sort = Sort.by(Sort.Direction.ASC, attributeName);
        return buildingRepo.findAll(BuildingSpecification.sortBy(attributeName), sort);
    }
}
