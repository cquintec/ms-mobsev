package com.mobdev.ms.service;

import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.dtos.CharacterResponse;
import com.mobdev.ms.exceptions.CharacterMapperException;

public interface CharacterMapperService {

    CharacterResponse convertCharacterToIntoCharacterResponse(
            CharacterDto characterDto, CharacterOriginDto characterLocationInfoDto)
            throws CharacterMapperException;


}
