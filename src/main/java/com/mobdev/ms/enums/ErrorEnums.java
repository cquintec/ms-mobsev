package com.mobdev.ms.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorEnums {
    CHARACTER_CLIENT_ERROR(1, "Error al consultar servicio Character :"),
    LOCATION_CLIENT_ERROR(2, "Error al consultar servicio Location :"),
    RQ_PARAMETER_MISSING(3, "Falta parametro en request"),
    BAD_TYPE_PARAMETER(4, "Tipo de dato no soportado :");

    private final Integer code;
    private final String message;

    public Integer getCode() {
        return this.code;
    }
    public String getMessage() {
        return this.message;
    }
}
