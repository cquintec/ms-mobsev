package com.mobdev.ms.restclients;

import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.exceptions.ApiClientException;

public interface IRyMLocationApiClient {
    CharacterOriginDto getCharacterOriginByName(String name) throws ApiClientException;
}
