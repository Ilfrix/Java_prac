package org.example.data;

import lombok.Data;

import java.util.Date;

@Data
public class GameDto {
    private String name;
    private Date creationDate;

    public String getName() {
        return name;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
