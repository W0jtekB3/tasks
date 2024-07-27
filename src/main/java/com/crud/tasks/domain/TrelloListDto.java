package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloListDto {
    private String id;
    private String name;
    private boolean isClosed;

    public TrelloListDto(String id, String name, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.isClosed = isClosed;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public boolean isClosed() { return isClosed; }
}