package com.mobdev.ms.restclients;

import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.enums.ErrorEnums;
import com.mobdev.ms.exceptions.ApiClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RyMLocationApiClient implements IRyMLocationApiClient{

    @Value("${rym.api.client.protocol}")
    private String protocol="https";
    @Value("${rym.api.client.base.paht}")
    private String basePath="//rickandmortyapi.com/api";
    @Value("${rym.api.client.location.path}")
    private String path="/location/?name=";
    RestTemplate restTemplate = new RestTemplate();
    public CharacterOriginDto getLocationByName(String name) throws ApiClientException {
        try {

            ResponseEntity<CharacterOriginDto> response =
                    restTemplate.getForEntity(createUrl(path)+name , CharacterOriginDto.class);

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
