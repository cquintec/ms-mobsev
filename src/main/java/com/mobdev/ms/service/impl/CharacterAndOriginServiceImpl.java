package com.mobdev.ms.service.impl;

import com.mobdev.ms.annotations.UseCase;
import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.dtos.CharacterResponse;
import com.mobdev.ms.exceptions.ApiClientException;
import com.mobdev.ms.exceptions.CharacterMapperException;
import com.mobdev.ms.service.CharacterAndOriginService;
import com.mobdev.ms.persistance.CharacterLocationService;
import com.mobdev.ms.mappers.ICharacterMapper;
import com.mobdev.ms.persistance.CharacterService;
import lombok.RequiredArgsConstructor;


@UseCase
@RequiredArgsConstructor
public class CharacterAndOriginServiceImpl implements CharacterAndOriginService {

    private final CharacterService characterService;
    private final CharacterLocationService locationService;
    private final ICharacterMapper characterMapperService;

    @Override
    public CharacterResponse getCharacterAndLocationInfo(Integer id)
            throws ApiClientException, CharacterMapperException {

        CharacterDto characterDto = characterService.getCharacterById(id);
        CharacterOriginDto characterLocationInfoDto = locationService
                .getCharacterOriginByName(characterDto.getOrigin().getName());

        return characterMapperService
                .convertCharacterToIntoCharacterResponse(characterDto,characterLocationInfoDto);
    }
}
