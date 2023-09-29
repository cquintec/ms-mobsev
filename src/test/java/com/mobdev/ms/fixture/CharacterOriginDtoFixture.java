package com.mobdev.ms.fixture;

import com.google.gson.Gson;
import com.mobdev.ms.MockLoaderBase;
import com.mobdev.ms.dtos.CharacterOriginDto;

public class CharacterOriginDtoFixture {

    public static CharacterOriginDto getCharacterOriginDto(){
        final var json = MockLoaderBase.loadJsonStringResponse("location_response.json");
        return new Gson().fromJson(json, CharacterOriginDto.class);
    }
}
