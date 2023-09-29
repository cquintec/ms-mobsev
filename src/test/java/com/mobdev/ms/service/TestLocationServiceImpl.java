package com.mobdev.ms.service;

import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.exceptions.ApiClientException;
import com.mobdev.ms.fixture.CharacterOriginDtoFixture;
import com.mobdev.ms.restclients.RyMLocationApiClient;
import com.mobdev.ms.service.impl.LocationServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TestLocationServiceImpl {

    @InjectMocks
    private LocationServiceImpl locationService;
    @Mock
    private RyMLocationApiClient ryMLocationApiClient;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetLocationInfoByLocationName_OK() throws ApiClientException {
        Mockito.when(ryMLocationApiClient.getLocationByName(Mockito.anyString()))
                .thenReturn(CharacterOriginDtoFixture.getCharacterOriginDto());
        CharacterOriginDto characterOriginDto = locationService.getLocationInfoByLocationName("Earth (C-137)");
        Assertions.assertFalse(characterOriginDto.getResults().isEmpty());
    }

}
