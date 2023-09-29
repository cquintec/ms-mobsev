package com.mobdev.ms.restclients;

import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.enums.ErrorEnums;
import com.mobdev.ms.exceptions.ApiClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RyMCharacterApiClient implements IRyMCharacterApiClient{

    @Value("${rym.api.client.protocol}")
    private String protocol;
    @Value("${rym.api.client.base.paht}")
    private String basePath;
    @Value("${rym.api.client.character.path}")
    private String path;
    RestTemplate restTemplate = new RestTemplate();
    public CharacterDto getCharacterById(Integer id) throws ApiClientException {
        try{

            ResponseEntity<CharacterDto> response =
                    restTemplate.getForEntity(createUrl(path)+id, CharacterDto.class);
            return response.getBody();
        }catch (Exception ex){
            throw new ApiClientException(
                    ErrorEnums.CHARACTER_CLIENT_ERROR.getMessage() + ex.getMessage(),
                    ErrorEnums.CHARACTER_CLIENT_ERROR.getCode());
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
