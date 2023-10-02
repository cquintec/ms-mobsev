package com.mobdev.ms.service.impl;

import com.mobdev.ms.annotations.PersistanceData;
import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.exceptions.ApiClientException;
import com.mobdev.ms.restclients.CharacterMapper;
import com.mobdev.ms.restclients.IRyMCharacterApiClient;
import com.mobdev.ms.restclients.IRyMLocationApiClient;
import com.mobdev.ms.service.CharacterLocationService;
import com.mobdev.ms.service.CharacterService;
import lombok.RequiredArgsConstructor;

@PersistanceData
@RequiredArgsConstructor
public class CharacterPersistanceImpl implements CharacterService, CharacterLocationService {

    private final IRyMLocationApiClient ryMLocationApiClient;
    private final IRyMCharacterApiClient ryMCharacterApiClient;

    @Override
    public CharacterDto getCharacterById(Integer id) throws ApiClientException {
        Object response = ryMCharacterApiClient.getCharacterById(id);
        return CharacterMapper.getCharacterFromResponseBody(response);
    }

    @Override
    public CharacterOriginDto getCharacterOriginByName(String name) throws ApiClientException {
        Object response = ryMLocationApiClient.getCharacterOriginByName(name);
        return CharacterMapper.getCharacterOriginFromResponseBody(response);
    }

}
