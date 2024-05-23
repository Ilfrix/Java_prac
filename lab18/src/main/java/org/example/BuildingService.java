package org.example;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BuildingService {
    public Long createBuilding(Building building);
    public List<Building> getBuildings();
    public void deleteBuilding(Long id);
    public List<Building> getBuildingsSortedBy(String attributeName);
}
