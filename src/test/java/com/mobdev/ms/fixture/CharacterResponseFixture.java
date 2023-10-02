package com.mobdev.ms.fixture;

import com.google.gson.Gson;
import com.mobdev.ms.MockLoaderBase;
import com.mobdev.ms.dtos.CharacterResponse;

public class CharacterResponseFixture {

    public static CharacterResponse getCharacterResponseFromJson(){
        final var json = MockLoaderBase.loadJsonStringResponse("character_response.json");
        return new Gson().fromJson(json, CharacterResponse.class);
    }
}
