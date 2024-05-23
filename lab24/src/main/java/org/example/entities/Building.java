package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entities.Game;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "building")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "creation_date")
    public Date creationDate;
    @Column(name = "type")
    public String type;
    @OneToMany(mappedBy = "building")
    private List<Game> games;
    public Building(Date creationDate, String type) {
        this.creationDate = creationDate;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {return type; }
}
