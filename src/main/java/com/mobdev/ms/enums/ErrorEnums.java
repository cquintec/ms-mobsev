package com.mobdev.ms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorEnums {
    CHARACTER_CLIENT_ERROR(1, "Error al consultar servicio Character :"),
    LOCATION_CLIENT_ERROR(2, "Error al consultar servicio Location :"),
    RQ_PARAMETER_MISSING(3, "Falta parametro en request"),
    BAD_TYPE_PARAMETER(4, "Tipo de dato no soportado :"),
    CHARACTER_MAPPER_ERROR(5, "Error conversion de datos :");

    private final Integer code;
    private final String message;

}
