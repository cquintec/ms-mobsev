package com.mobdev.ms.dtos;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CharacterOriginDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private CharacterOriginResponseInfo info;
    private List<CharacterOriginInfoDto> results;
}
