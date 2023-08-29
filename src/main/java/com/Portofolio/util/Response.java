package com.Portofolio.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Setter
@Getter
public class Response<T> {
    @JsonProperty
    private Integer responseCode;
    @JsonProperty
    private String responseMasage;
    @JsonProperty
    @Nullable
    private T data;
}
