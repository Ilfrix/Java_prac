package org.example;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "game_authors")
public class GameAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    public String nickname;
    public Date birthDay;

}
