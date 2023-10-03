package com.mobdev.ms.service;

import com.mobdev.ms.dtos.CharacterResponse;
import com.mobdev.ms.exceptions.ApiClientException;
import com.mobdev.ms.exceptions.CharacterMapperException;
import com.mobdev.ms.fixture.CharacterDtoFixture;
import com.mobdev.ms.fixture.CharacterOriginDtoFixture;
import com.mobdev.ms.fixture.CharacterResponseFixture;
import com.mobdev.ms.mappers.ICharacterMapper;
import com.mobdev.ms.persistance.CharacterLocationService;
import com.mobdev.ms.persistance.CharacterService;
import com.mobdev.ms.service.impl.CharacterAndOriginServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestCharacterServiceImpl {

    @InjectMocks
    private CharacterAndOriginServiceImpl characterAndOriginService;

    @Mock
    private CharacterService characterService;
    @Mock
    private CharacterLocationService locationService;
    @Mock
    private ICharacterMapper characterMapperService;

    @DisplayName("getCharacter test OK")
    @Test
    void testGetCharacterInfoById_OK() throws ApiClientException, CharacterMapperException {

        Mockito.when(characterService.getCharacterById(Mockito.anyInt()))
                .thenReturn(CharacterDtoFixture.getCharacterDto());
        Mockito.when(locationService.getCharacterOriginByName(Mockito.anyString()))
                .thenReturn(CharacterOriginDtoFixture.getCharacterOriginDto());
        Mockito.when(characterMapperService.convertCharacterToIntoCharacterResponse(Mockito.any(),Mockito.any()))
                .thenReturn(CharacterResponseFixture.getCharacterResponseFromJson());

        CharacterResponse characterDto = characterAndOriginService.getCharacterAndLocationInfo(1);
        Assertions.assertFalse(characterDto.getName().isEmpty());
    }
}
