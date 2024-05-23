package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "games")
public class Game  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name="name")
    public String name;
    @Column(name="creationDate")
    public Date creationDate;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "building_id")
    public Building building;

    public Game(GameDto gameDto) {
        this.name = gameDto.getName();
        this.creationDate = gameDto.getCreationDate();
    }

    public void setData(GameDto gameDto) {
        this.name = gameDto.getName();
        this.creationDate = gameDto.getCreationDate();
    }
}
