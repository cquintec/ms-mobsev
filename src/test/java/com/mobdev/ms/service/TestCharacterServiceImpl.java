package com.mobdev.ms.service;

import com.mobdev.ms.dtos.CharacterResponse;
import com.mobdev.ms.exceptions.ApiClientException;
import com.mobdev.ms.fixture.CharacterDtoFixture;
import com.mobdev.ms.fixture.CharacterOriginDtoFixture;
import com.mobdev.ms.fixture.CharacterResponseFixture;
import com.mobdev.ms.restclients.IRyMCharacterApiClient;
import com.mobdev.ms.restclients.IRyMLocationApiClient;
import com.mobdev.ms.service.impl.CharacterAndOriginServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TestCharacterServiceImpl {

    @InjectMocks
    private CharacterAndOriginServiceImpl characterAndOriginService;

    @Mock
    private CharacterService characterService;
    @Mock
    private CharacterLocationService locationService;
    @Mock
    private CharacterMapperService characterMapperService;


    @BeforeEach
    void setup() {MockitoAnnotations.openMocks(this);}

    @DisplayName("getCharacter test OK")
    @Test
    void testGetCharacterInfoById_OK() throws ApiClientException {

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
