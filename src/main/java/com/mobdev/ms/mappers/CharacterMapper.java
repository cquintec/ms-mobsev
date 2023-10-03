package com.mobdev.ms.mappers;

import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.dtos.CharacterOriginInfoDto;
import com.mobdev.ms.dtos.CharacterResponse;
import com.mobdev.ms.dtos.LocationResponse;
import com.mobdev.ms.enums.ErrorEnums;
import com.mobdev.ms.exceptions.CharacterMapperException;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper implements ICharacterMapper {
    @Override
    public CharacterResponse convertCharacterToIntoCharacterResponse(
            CharacterDto characterDto, CharacterOriginDto characterLocationInfoDto)
            throws CharacterMapperException {
        try {

            CharacterOriginInfoDto characterOriginDto = characterLocationInfoDto.getResults()
                    .stream()
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);

            LocationResponse origin = LocationResponseMapper
                    .locationResponseMapper(characterOriginDto);

            return CharacterResponseMapper
                    .characterResponseMapper(characterDto,origin);

        }catch (Exception ex){
            throw new CharacterMapperException(ErrorEnums.CHARACTER_MAPPER_ERROR.getMessage(),
                    ErrorEnums.CHARACTER_MAPPER_ERROR.getCode());
        }
    }

}
