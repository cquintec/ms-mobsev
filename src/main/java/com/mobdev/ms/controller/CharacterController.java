package com.mobdev.ms.controller;

import com.mobdev.ms.dtos.CharacterResponse;
import com.mobdev.ms.exceptions.ApiClientException;
import com.mobdev.ms.service.CharacterAndOriginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class CharacterController {

    private final CharacterAndOriginService characterAndOriginService;
    @GetMapping(value = "/character",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CharacterResponse getCharacterAndLocationInfo(@RequestParam Integer id) throws ApiClientException {

        return characterAndOriginService.getCharacterAndLocationInfo(id);
    }
}
