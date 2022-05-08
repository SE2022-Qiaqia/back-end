package com.whu.se2022.qiaqia.coursesystem.dto.response;

import lombok.Data;

@Data
public class Response<T> {

    private int code;
    private String msg;
    private T data;

}
