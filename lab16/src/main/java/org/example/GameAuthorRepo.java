package org.example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameAuthorRepo extends JpaRepository<GameAuthor, UUID> {
}
