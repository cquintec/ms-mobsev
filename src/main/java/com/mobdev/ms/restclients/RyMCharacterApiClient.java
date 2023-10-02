package com.mobdev.ms.restclients;

import com.mobdev.ms.annotations.DataRepository;
import com.mobdev.ms.enums.ErrorEnums;
import com.mobdev.ms.exceptions.ApiClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@DataRepository
public class RyMCharacterApiClient implements IRyMCharacterApiClient, IRyMLocationApiClient{

    @Value("${rym.api.client.protocol}")
    private String protocol;
    @Value("${rym.api.client.base.paht}")
    private String basePath;
    @Value("${rym.api.client.character.path}")
    private String characterPath;
    @Value("${rym.api.client.location.path}")
    private String locationPath;

    RestTemplate restTemplate = new RestTemplate();
    public Object getCharacterById(Integer id) throws ApiClientException {
        try{

            ResponseEntity<Object> response =
                    restTemplate.getForEntity(createUrl(this.characterPath)+id, Object.class);

            return response.getBody();
        }catch (Exception ex){
            throw new ApiClientException(
                    ErrorEnums.CHARACTER_CLIENT_ERROR.getMessage() + ex.getMessage(),
                    ErrorEnums.CHARACTER_CLIENT_ERROR.getCode());
        }
    }

    public Object getCharacterOriginByName(String name) throws ApiClientException {
        try {

            ResponseEntity<Object> response =
                    restTemplate.getForEntity(createUrl(this.locationPath)+name , Object.class);

            return response.getBody();
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
