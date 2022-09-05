package com.sns.dongore.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpResponse;
import org.springframework.http.HttpStatus;

@Getter @Setter @AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "statusCode", "detail", "result"})
public class BaseResponse<T> {
    public static final BaseResponseStatus SUCCESS = BaseResponseStatus.SUCCESS;
    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final HttpStatus statusCode;
    private final String detail;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    public BaseResponse(T result){
        this.isSuccess = SUCCESS.getIsSuccess();
        this.detail = SUCCESS.getDetail();
        this.statusCode = SUCCESS.getStatusCode();
        this.result = result;
    }

    public BaseResponse(BaseResponseStatus error){
        this.isSuccess = error.getIsSuccess();
        this.detail = error.getDetail();
        this.statusCode = error.getStatusCode();
    }
}
