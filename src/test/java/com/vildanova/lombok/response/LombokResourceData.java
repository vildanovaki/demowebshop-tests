package com.vildanova.lombok.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LombokResourceData {

        private int page;
        @JsonProperty("total_pages")
        private int totalPages;
        private List<Resource> data;
        private SupportResponse support;
}
