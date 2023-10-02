package com.mobdev.ms.service;

import com.mobdev.ms.dtos.CharacterDto;
import com.mobdev.ms.dtos.CharacterOriginDto;
import com.mobdev.ms.dtos.CharacterResponse;
import com.mobdev.ms.exceptions.CharacterMapperException;
import com.mobdev.ms.fixture.CharacterDtoFixture;
import com.mobdev.ms.fixture.CharacterOriginDtoFixture;
import com.mobdev.ms.service.impl.CharacterMapperServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class TestCharacterMapperServiceImpl {

    @InjectMocks
    private CharacterMapperServiceImpl characterMapperService;

    @Test
    void testConvertDomainToResponse_OK() throws CharacterMapperException {

        CharacterDto character = CharacterDtoFixture.getCharacterDto();
        CharacterOriginDto characterOrigin = CharacterOriginDtoFixture.getCharacterOriginDto();
        CharacterResponse characterResponse = characterMapperService
                .convertCharacterToIntoCharacterResponse(character, characterOrigin);
        assertAll("response",
                () -> assertNotNull(characterResponse),
                () ->assertNotNull(characterResponse.getOrigin()));
    }

    @Test
    void testConvertDomainToResponse_character_missing() throws CharacterMapperException {

        CharacterDto character = null;
        Assertions.assertThrows(CharacterMapperException.class,
                () -> this.characterMapperService
                        .convertCharacterToIntoCharacterResponse(character, null));
    }

    @Test
    void testConvertDomainToResponse_character_loaction_missing() throws CharacterMapperException {

        CharacterDto character = null;
        Assertions.assertThrows(CharacterMapperException.class,
                () -> this.characterMapperService
                        .convertCharacterToIntoCharacterResponse(character, null));
    }
}
