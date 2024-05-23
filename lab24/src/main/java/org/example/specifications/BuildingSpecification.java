package org.example.specifications;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.entities.Building;
import org.springframework.data.jpa.domain.Specification;

public class BuildingSpecification {
    public static Specification<Building> sortBy(String attributeName) {
        return new Specification<Building>() {
            @Override
            public Predicate toPredicate(Root<Building> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                query.orderBy(criteriaBuilder.asc(root.get(attributeName)));
                return null;
            }
        };
    }
}
