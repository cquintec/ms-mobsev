package com.mobdev.ms.service.impl;

import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.exceptions.ApiClientException;
import com.mobdev.ms.restclients.RyMLocationApiClient;
import com.mobdev.ms.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final RyMLocationApiClient ryMLocationApiClient;

    @Override
    public CharacterOriginDto getLocationInfoByLocationName(String locationName) throws ApiClientException {
       return ryMLocationApiClient.getLocationByName(locationName);
    }
}
