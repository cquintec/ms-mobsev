package com.mobdev.ms.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class LocationResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String url;
    private String dimension;
    private List<String> residents;
}
