package com.mobdev.ms.restclients;

import com.mobdev.ms.exceptions.ApiClientException;

public interface IRyMLocationApiClient {
    Object getCharacterOriginByName(String name) throws ApiClientException;
}
