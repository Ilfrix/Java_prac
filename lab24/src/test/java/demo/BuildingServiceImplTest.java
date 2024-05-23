package demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import org.example.entities.Building;
import org.example.repository.BuildingRepo;
import org.example.services.BuildingServiceImpl;

import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BuildingServiceImplTest {
    @Mock
    private BuildingRepo buildingRepo;

    @Captor
    ArgumentCaptor<Building> captor;

    @Test
    public void createBuilding() {
        Building build = new Building(new Date(1000000), "office");
        BuildingServiceImpl service = new BuildingServiceImpl(buildingRepo);
        service.createBuilding(build);
        Mockito.verify(buildingRepo).save(captor.capture());
        Building captured = captor.getValue();
        assertEquals("office", captured.getType());
    }

    @Test
    public void getBuildings() {
        Building addr = new Building(new Date(100000), "office");
        Building addr1 = new Building(new Date(9999999), "warehouse");
        Mockito.when(buildingRepo.findAll()).thenReturn(List.of(addr, addr1));
        BuildingServiceImpl service = new BuildingServiceImpl(buildingRepo);
        Assertions.assertEquals(2, service.getBuildings().size());
        Assertions.assertEquals("office", service.getBuildings().get(0).getType());
    }

    @Test
    public void deleteBuilding() {
        Long id = (long)1;
        buildingRepo.deleteById(id);
    }

    @Test
    public void getBuildingsSortedBy() {
        Building addr = new Building(new Date(100), "office");
        Building addr1 = new Building(new Date(10000), "warehouse");
        Mockito.when(buildingRepo.findAll(any(Specification.class), any(Sort.class))).thenReturn(List.of(addr1, addr));
        BuildingServiceImpl service = new BuildingServiceImpl(buildingRepo);
        Assertions.assertEquals(2, service.getBuildingsSortedBy("type").size());
    }
}
