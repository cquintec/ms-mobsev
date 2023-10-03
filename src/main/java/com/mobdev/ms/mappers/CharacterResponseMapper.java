package com.mobdev.ms.mappers;

import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.dtos.CharacterResponse;
import com.mobdev.ms.dtos.LocationResponse;

public class CharacterResponseMapper {
    public static CharacterResponse characterResponseMapper(
            CharacterDto characterDto,LocationResponse locationResponse){

        return CharacterResponse.builder()
                .id(characterDto.getId())
                .name(characterDto.getName())
                .status(characterDto.getStatus())
                .species(characterDto.getSpecies())
                .type(characterDto.getType())
                .episodeCount(characterDto.getEpisode().size())
                .origin(locationResponse)
                .build();
    }
}
