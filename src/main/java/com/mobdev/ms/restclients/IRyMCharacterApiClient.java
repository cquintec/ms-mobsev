package com.mobdev.ms.restclients;

import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.exceptions.ApiClientException;

public interface IRyMCharacterApiClient {
    CharacterDto getCharacterById(Integer id) throws ApiClientException;
}
