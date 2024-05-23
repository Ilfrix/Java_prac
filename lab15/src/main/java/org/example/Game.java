package org.example;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@Table(name = "gamess")
public class Game  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    @Column(name="name")
    public String name;
    @Column(name="creatioDate")
    public Date creationDate;

    public Game(UUID id, String name, Date creationDate){
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }
}
