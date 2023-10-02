package com.mobdev.ms.restclients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.dtos.CharacterOriginDto;


public class CharacterMapper {

    public static CharacterOriginDto getCharacterOriginFromResponseBody(Object response) {
        ObjectMapper mapper= new ObjectMapper();
        return mapper.convertValue(response,CharacterOriginDto.class);
    }

    public static CharacterDto getCharacterFromResponseBody(Object response) {
        ObjectMapper mapper= new ObjectMapper();
        return mapper.convertValue(response,(CharacterDto.class));
    }

}
