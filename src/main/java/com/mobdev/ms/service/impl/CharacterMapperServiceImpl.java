package com.mobdev.ms.service.impl;

import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.dtos.CharacterOriginInfoDto;
import com.mobdev.ms.dtos.CharacterResponse;
import com.mobdev.ms.dtos.LocationResponse;
import com.mobdev.ms.service.CharacterMapperService;
import org.springframework.stereotype.Service;

@Service
public class CharacterMapperServiceImpl implements CharacterMapperService {
    @Override
    public CharacterResponse convertCharacterToIntoCharacterResponse(
            CharacterDto characterDto, CharacterOriginDto characterLocationInfoDto) {


        CharacterOriginInfoDto result= characterLocationInfoDto.getResults()
                .stream()
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        LocationResponse origin= LocationResponse.builder()
                .name(result.getName())
                .url(result.getUrl())
                .dimension(result.getDimension())
                .residents(result.getResidents())
                .build();

        return CharacterResponse.builder()
                .id(characterDto.getId())
                .name(characterDto.getName())
                .status(characterDto.getStatus())
                .species(characterDto.getSpecies())
                .type(characterDto.getType())
                .episodeCount(characterDto.getEpisode().size())
                .origin(origin)
                .build();
    }
}
