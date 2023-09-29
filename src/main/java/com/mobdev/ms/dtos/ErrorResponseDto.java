package com.mobdev.ms.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@Builder
public class ErrorResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private LocalDateTime timeStamp;
    private Integer codigo;
    private String detail;
}
