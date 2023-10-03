package com.mobdev.ms.service;

import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.dtos.CharacterOriginResponseInfo;
import com.mobdev.ms.dtos.CharacterResponse;
import com.mobdev.ms.exceptions.CharacterMapperException;
import com.mobdev.ms.fixture.CharacterDtoFixture;
import com.mobdev.ms.fixture.CharacterOriginDtoFixture;
import com.mobdev.ms.mappers.CharacterMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TestConvertDtoToResponseObjectServiceImpl {

    @InjectMocks
    private CharacterMapper characterMapper;

    @DisplayName("Dto convert to Response OK")
    @Test
    void testConvertCharacterToIntoCharacterResponse_OK() throws CharacterMapperException {
        CharacterDto characterDto = CharacterDtoFixture.getCharacterDto();
        CharacterOriginDto characterOriginDto = CharacterOriginDtoFixture.getCharacterOriginDto();
        CharacterResponse response = characterMapper.convertCharacterToIntoCharacterResponse(
                characterDto,
                characterOriginDto);
        assertAll("response",
                () -> assertEquals(characterDto.getId(),response.getId()),
                () ->assertEquals(characterOriginDto.getResults().get(0).getName(),
                        response.getOrigin().getName()));
    }

    @DisplayName("Dto convert to Response CharacterLocation empty")
    @Test
    void testConvertCharacterToIntoCharacterResponse_CharacterLocation_No_Data(){
        CharacterDto characterDto = CharacterDtoFixture.getCharacterDto();
        CharacterOriginDto characterOriginDto =
                new CharacterOriginDto(new CharacterOriginResponseInfo(),new ArrayList<>());
        Assertions.assertThrows(CharacterMapperException.class,
                () -> this.characterMapper.convertCharacterToIntoCharacterResponse(
                characterDto,
                characterOriginDto));
    }

    @DisplayName("Dto convert to Response CharacterLocation empty")
    @Test
    void testConvertCharacterToIntoCharacterResponse_Character_No_Data(){
        CharacterDto characterDto = new CharacterDto();
        CharacterOriginDto characterOriginDto =
                new CharacterOriginDto(new CharacterOriginResponseInfo(),new ArrayList<>());
        Assertions.assertThrows(CharacterMapperException.class,
                () -> this.characterMapper.convertCharacterToIntoCharacterResponse(
                        characterDto,
                        characterOriginDto));
    }

}
