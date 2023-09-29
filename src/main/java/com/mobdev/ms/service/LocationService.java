package com.mobdev.ms.service;

import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.exceptions.ApiClientException;

public interface LocationService {

    CharacterOriginDto getLocationInfoByLocationName(String locationName) throws ApiClientException;
}
