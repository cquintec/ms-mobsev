package com.mobdev.ms.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CharacterResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private int episodeCount;
    private LocationResponse origin;
}
