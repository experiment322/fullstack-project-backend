package com.mad.backend.dtos;

/**
 * Created by alex on 2/27/17.
 */
public class ResponseDto<T> {

    private T data;

    public ResponseDto(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
