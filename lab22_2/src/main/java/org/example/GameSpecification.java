package org.example;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class GameSpecification {
    public static Specification<Game> sortBy(String attributeName) {
        return new Specification<Game>() {
            @Override
            public Predicate toPredicate(Root<Game> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                query.orderBy(criteriaBuilder.asc(root.get(attributeName)));
                return null;
            }
        };
    }
}
