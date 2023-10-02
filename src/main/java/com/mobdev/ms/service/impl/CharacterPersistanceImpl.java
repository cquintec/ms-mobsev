package com.mobdev.ms.service.impl;

import com.mobdev.ms.annotations.PersistanceData;
import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.enums.ErrorEnums;
import com.mobdev.ms.exceptions.ApiClientException;
import com.mobdev.ms.restclients.CharacterMapper;
import com.mobdev.ms.restclients.IRyMCharacterApiClient;
import com.mobdev.ms.restclients.IRyMLocationApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@PersistanceData
public class CharacterPersistanceImpl implements IRyMCharacterApiClient, IRyMLocationApiClient {

    @Value("${rym.api.client.protocol}")
    private String protocol;
    @Value("${rym.api.client.base.paht}")
    private String basePath;
    @Value("${rym.api.client.character.path}")
    private String characterPath;
    @Value("${rym.api.client.location.path}")
    private String locatioPath;
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public CharacterDto getCharacterById(Integer id) throws ApiClientException {
        try{

            ResponseEntity<Object> response =
                    restTemplate.getForEntity(createUrl(characterPath)+id, Object.class);

            return CharacterMapper.getCharacterFromResponseBody(response.getBody());
        }catch (Exception ex){
            throw new ApiClientException(
                    ErrorEnums.CHARACTER_CLIENT_ERROR.getMessage() + ex.getMessage(),
                    ErrorEnums.CHARACTER_CLIENT_ERROR.getCode());
        }
    }

    @Override
    public CharacterOriginDto getCharacterOriginByName(String name) throws ApiClientException {
        try {

            ResponseEntity<Object> response =
                    restTemplate.getForEntity(createUrl(locatioPath)+name , Object.class);

            return CharacterMapper.getCharacterOriginFromResponseBody(response.getBody());
        }catch (Exception ex){
            throw new ApiClientException(
                    ErrorEnums.LOCATION_CLIENT_ERROR.getMessage()+ ex.getMessage(),
                    ErrorEnums.LOCATION_CLIENT_ERROR.getCode());
        }
    }

    private String createUrl(String path) {
        return new StringBuilder()
                .append(this.protocol)
                .append(":")
                .append(this.basePath)
                .append(path).toString();
    }
}
