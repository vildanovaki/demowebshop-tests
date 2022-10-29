package com.vildanova.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vildanova.lombok.response.SingleUser;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleUserDataModel {

    private SingleUser data;

    public SingleUser getData() {
        return data;
    }

    public void setData(SingleUser data) {
        this.data = data;
    }
}
