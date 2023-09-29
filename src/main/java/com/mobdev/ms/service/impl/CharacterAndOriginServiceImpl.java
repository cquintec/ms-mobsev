package com.mobdev.ms.service.impl;

import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.dtos.CharacterResponse;
import com.mobdev.ms.exceptions.ApiClientException;
import com.mobdev.ms.restclients.IRyMCharacterApiClient;
import com.mobdev.ms.restclients.IRyMLocationApiClient;
import com.mobdev.ms.service.CharacterAndOriginService;
import com.mobdev.ms.service.CharacterMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterAndOriginServiceImpl implements CharacterAndOriginService {

    private final IRyMCharacterApiClient ryMCharacterApiClient;
    private final IRyMLocationApiClient ryMLocationApiClient;
    private final CharacterMapperService dtoToResponseObjectService;

    @Override
    public CharacterResponse getCharacterAndLocationInfo(Integer id) throws ApiClientException {
        CharacterDto characterDto = ryMCharacterApiClient.getCharacterById(id);
        CharacterOriginDto characterLocationInfoDto = ryMLocationApiClient
                .getLocationByName(characterDto.getOrigin().getName());

        return dtoToResponseObjectService
                .convertCharacterToIntoCharacterResponse(characterDto,characterLocationInfoDto);
    }
}
