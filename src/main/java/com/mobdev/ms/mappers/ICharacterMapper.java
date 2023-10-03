package com.mobdev.ms.mappers;

import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.dtos.CharacterResponse;
import com.mobdev.ms.exceptions.CharacterMapperException;

public interface ICharacterMapper {

    CharacterResponse convertCharacterToIntoCharacterResponse(
            CharacterDto characterDto, CharacterOriginDto characterLocationInfoDto)
            throws CharacterMapperException;


}
