package org.example;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "games")
public class Game  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    @Column(name="name")
    public String name;
    @Column(name="creatioDate")
    public Date creationDate;
    @ManyToOne
    @JoinColumn(name="games")
    private GameAuthor gameAuthor;

    public Game(GameDto gameDto) {
        this.name = gameDto.getName();
        this.creationDate = gameDto.getCreationDate();
    }

    public void setData(GameDto gameDto) {
        this.name = gameDto.getName();
        this.creationDate = gameDto.getCreationDate();
    }
}
