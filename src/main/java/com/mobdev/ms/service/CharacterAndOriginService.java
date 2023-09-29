package com.mobdev.ms.service;

import com.mobdev.ms.dtos.CharacterResponse;
import com.mobdev.ms.exceptions.ApiClientException;

public interface CharacterAndOriginService {

    CharacterResponse getCharacterAndLocationInfo(Integer id) throws ApiClientException;
}
