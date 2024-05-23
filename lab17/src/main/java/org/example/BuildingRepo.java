package org.example;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepo extends JpaRepository<Building, Long> {
    List<Building> findAll(Specification<Building> specification, Sort sort);
}
