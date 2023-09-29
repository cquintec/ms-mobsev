package com.mobdev.ms.service;

import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.dtos.CharacterOriginResponseInfo;
import com.mobdev.ms.dtos.CharacterResponse;
import com.mobdev.ms.fixture.CharacterDtoFixture;
import com.mobdev.ms.fixture.CharacterOriginDtoFixture;
import com.mobdev.ms.service.impl.CharacterMapperServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestConvertDtoToResponseObjectServiceImpl {

    @InjectMocks
    private CharacterMapperServiceImpl dtoToResponseObjectService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);}

    @DisplayName("Dto convert to Response OK")
    @Test
    void testConvertCharacterToIntoCharacterResponse_OK(){
        CharacterDto characterDto = CharacterDtoFixture.getCharacterDto();
        CharacterOriginDto characterOriginDto = CharacterOriginDtoFixture.getCharacterOriginDto();
        CharacterResponse response = dtoToResponseObjectService.convertCharacterToIntoCharacterResponse(
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
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> this.dtoToResponseObjectService.convertCharacterToIntoCharacterResponse(
                characterDto,
                characterOriginDto));
    }
}
