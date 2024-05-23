package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameAuthorRepository extends JpaRepository<GameAuthor, UUID> {
}
