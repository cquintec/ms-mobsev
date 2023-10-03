package com.mobdev.ms.persistance;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobdev.ms.annotations.PersistanceData;
import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.exceptions.ApiClientException;
import com.mobdev.ms.restclients.IRyMCharacterApiClient;
import com.mobdev.ms.restclients.IRyMLocationApiClient;
import lombok.RequiredArgsConstructor;

@PersistanceData
@RequiredArgsConstructor
public class CharacterPersistanceImpl implements CharacterService, CharacterLocationService {

    private final IRyMLocationApiClient ryMLocationApiClient;
    private final IRyMCharacterApiClient ryMCharacterApiClient;

    @Override
    public CharacterDto getCharacterById(Integer id) throws ApiClientException {
        Object response = ryMCharacterApiClient.getCharacterById(id);
        return getCharacterFromResponseBody(response);
    }

    @Override
    public CharacterOriginDto getCharacterOriginByName(String name) throws ApiClientException {
        Object response = ryMLocationApiClient.getCharacterOriginByName(name);
        return getCharacterOriginFromResponseBody(response);
    }

    private CharacterOriginDto getCharacterOriginFromResponseBody(Object response) {
        ObjectMapper mapper= new ObjectMapper();
        return mapper.convertValue(response,CharacterOriginDto.class);
    }

    private CharacterDto getCharacterFromResponseBody(Object response) {
        ObjectMapper mapper= new ObjectMapper();
        return mapper.convertValue(response,(CharacterDto.class));
    }
}
