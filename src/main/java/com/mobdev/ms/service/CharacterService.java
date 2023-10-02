package com.mobdev.ms.service;

import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.exceptions.ApiClientException;

public interface CharacterService {

    CharacterDto getCharacterById(Integer id) throws ApiClientException;
}
