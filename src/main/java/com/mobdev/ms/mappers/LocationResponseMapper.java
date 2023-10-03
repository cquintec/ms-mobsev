package com.mobdev.ms.mappers;

import com.mobdev.ms.dtos.CharacterOriginInfoDto;
import com.mobdev.ms.dtos.LocationResponse;

public class LocationResponseMapper {

    public static LocationResponse locationResponseMapper(CharacterOriginInfoDto characterOriginInfoDto){
        return LocationResponse.builder()
                .name(characterOriginInfoDto.getName())
                .url(characterOriginInfoDto.getUrl())
                .dimension(characterOriginInfoDto.getDimension())
                .residents(characterOriginInfoDto.getResidents())
                .build();
    }
}
