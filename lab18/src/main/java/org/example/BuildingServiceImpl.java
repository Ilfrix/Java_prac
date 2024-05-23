package org.example;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuildingServiceImpl implements BuildingService{
    private BuildingRepo buildingRepo;
    @Override
    public Long createBuilding(Building building) {
        buildingRepo.save(building);
        return building.getId();
    }

    @Override
    public List<Building> getBuildings() {
        return buildingRepo.findAll();
    }

    @Override
    public void deleteBuilding(Long id) {
        buildingRepo.deleteById(id);
    }

    @Override
    public List<Building> getBuildingsSortedBy(String attributeName) {
        Sort sort = Sort.by(Sort.Direction.ASC, attributeName);
        return buildingRepo.findAll(BuildingSpecification.sortBy(attributeName), sort);
    }
}
