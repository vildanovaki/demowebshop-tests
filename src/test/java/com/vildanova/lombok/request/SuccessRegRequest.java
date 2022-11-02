package com.vildanova.lombok.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuccessRegRequest {

    private String email = "eve.holt@reqres.in";
    private String password = "pistol";
}
