package com.mobdev.ms.restclient;

import com.mobdev.ms.exceptions.ApiClientException;
import com.mobdev.ms.fixture.CharacterDtoFixture;
import com.mobdev.ms.restclients.RyMCharacterApiClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@ExtendWith(MockitoExtension.class)
public class TestRyMCharacterApiClient {

    @InjectMocks
    private RyMCharacterApiClient ryMCharacterApiClient;

    @Mock
    private RestTemplate restTemplate;

    @Test
    void getCharacterById_ok() throws ApiClientException {
        Mockito.when(restTemplate.getForEntity(Mockito.anyString(),Mockito.any()))
                .thenReturn(new ResponseEntity<>(CharacterDtoFixture.getCharacterDto(), HttpStatus.OK));
        Object responseObject = ryMCharacterApiClient.getCharacterById(1);
        Assertions.assertNotNull(responseObject);
    }

    @Test
    void getCharacterOriginByName_ok() throws ApiClientException {
        Mockito.when(restTemplate.getForEntity(Mockito.anyString(),Mockito.any()))
                .thenReturn(new ResponseEntity<>(CharacterDtoFixture.getCharacterDto(), HttpStatus.OK));
        Object responseObject = ryMCharacterApiClient.getCharacterOriginByName("some name");
        Assertions.assertNotNull(responseObject);
    }

}
