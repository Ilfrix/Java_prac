package org.example.repository;

import org.example.entities.Game;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface GameRepo extends JpaRepository<Game, UUID> {
    List<Game> findAll(Specification<Game> specification, Sort sort);

    void deleteById(Long id);
}
