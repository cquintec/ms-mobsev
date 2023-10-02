package com.mobdev.ms.service;

import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.exceptions.ApiClientException;

public interface CharacterLocationService {

    CharacterOriginDto getCharacterOriginByName(String name) throws ApiClientException;
}
