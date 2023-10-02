package com.mobdev.ms.service;

import com.mobdev.ms.dtos.CharacterResponse;
import com.mobdev.ms.exceptions.ApiClientException;
import com.mobdev.ms.exceptions.CharacterMapperException;

public interface CharacterAndOriginService {

    CharacterResponse getCharacterAndLocationInfo(Integer id) throws ApiClientException, CharacterMapperException;
}
