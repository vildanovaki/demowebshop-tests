package com.vildanova.lombok.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnsuccessRegRequest {

    private String email = "sydney@fife";
}
