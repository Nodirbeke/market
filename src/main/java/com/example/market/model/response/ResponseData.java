package com.example.market.model.response;

import com.example.market.enums.StatusCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T> {

    private T data;
    private APIErrorDTO errorDTO;
    private Integer status;
    private Boolean success;

    public ResponseData(T data) {
        this.data = data;
        this.status = StatusCode.SUCCESS.getStatus();
        this.success = true;
    }

    public ResponseData(APIErrorDTO errorDTO, int status) {
        this.errorDTO = errorDTO;
        this.status = status;
        this.success = false;
    }
}
