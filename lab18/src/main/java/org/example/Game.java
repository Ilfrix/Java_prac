package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

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
    @Column(name="creatioDate")
    public Date creationDate;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "building_id")
    public Building building;

    public Game(GameDto gameDto) {
        this.name = gameDto.getName();
        this.creationDate = gameDto.getCreationDate();
    }

    public Game(String name, Date creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public void setData(GameDto gameDto) {
        this.name = gameDto.getName();
        this.creationDate = gameDto.getCreationDate();
    }
}
