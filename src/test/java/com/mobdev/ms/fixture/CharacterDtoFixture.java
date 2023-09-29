package com.mobdev.ms.fixture;

import com.google.gson.Gson;
import com.mobdev.ms.MockLoaderBase;
import com.mobdev.ms.dtos.CharacterDto;

public class CharacterDtoFixture {
    public static CharacterDto getCharacterDto(){
        final var json = MockLoaderBase.loadJsonStringResponse("character_response.json");
        return new Gson().fromJson(json, CharacterDto.class);
    }
}
