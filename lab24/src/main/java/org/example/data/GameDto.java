package org.example.data;

import lombok.Data;

import java.util.Date;

@Data
public class GameDto {
    private String name;
    private Date creationDate;
    public GameDto(String name, Date creationDate){
        this.name = name;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
