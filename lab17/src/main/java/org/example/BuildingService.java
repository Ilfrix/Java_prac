package org.example;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuildingService {
    private BuildingRepo buildingRepo;

    public Long createBuilding(Building building){
        buildingRepo.save(building);
        return building.getId();
    }
    public List<Building> getBuildings() {
        return buildingRepo.findAll();
    }

    public void deleteBuilding(Long id) {
        buildingRepo.deleteById(id);
    }

    public List<Building> getBuildingsSortedBy(String attributeName){
        Sort sort = Sort.by(Sort.Direction.ASC, attributeName);
        return buildingRepo.findAll(BuildingSpecification.sortBy(attributeName), sort);
    }
}
