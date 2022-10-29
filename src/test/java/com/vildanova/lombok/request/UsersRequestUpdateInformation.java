package com.vildanova.lombok.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersRequestUpdateInformation {

    private String name = "morpheus";
    private String job = "zion resident";
}
