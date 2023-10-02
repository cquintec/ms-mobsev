package com.mobdev.ms.restclients;

import com.mobdev.ms.exceptions.ApiClientException;

public interface IRyMCharacterApiClient {
    Object getCharacterById(Integer id) throws ApiClientException;
}
