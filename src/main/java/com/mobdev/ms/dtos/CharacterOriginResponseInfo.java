package com.mobdev.ms.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CharacterOriginResponseInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
