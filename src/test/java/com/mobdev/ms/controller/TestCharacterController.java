package com.mobdev.ms.controller;

import com.mobdev.ms.fixture.CharacterResponseFixture;
import com.mobdev.ms.service.impl.CharacterAndOriginServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class TestCharacterController {

    @MockBean
    private CharacterAndOriginServiceImpl characterAndOriginService;
    @Autowired
    private MockMvc mockMvc;

   @Test
   public void testGetCharacterAndLocationInfo() throws Exception
   {
       Mockito.when(characterAndOriginService.getCharacterAndLocationInfo(Mockito.anyInt()))
               .thenReturn(CharacterResponseFixture.getCharacterResponseFromJson());
       this.mockMvc
               .perform(MockMvcRequestBuilders.get("/v1/character")
                       .param("id", String.valueOf(1))
                       .contentType(MediaType.APPLICATION_JSON_VALUE))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE));
   }
}
