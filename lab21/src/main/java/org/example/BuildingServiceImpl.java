package org.example;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class BuildingServiceImpl implements BuildingService{
    private BuildingRepo buildingRepo;
    @Autowired
    private EmailService emailService;
    @Override
    public Long createBuilding(Building building) {
//        log.info("create building {}", building);
        emailService.sendMessage("vya.polyanskiy@gmail.com", "Object creation", building.toString());
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
