package com.whu.se2022.qiaqia.coursesystem.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseRes<T> {
    private int code;
    private String msg;
    private T data;

    public ResponseRes(T data){
        this.code = 400;
        this.msg="success";
        this.data = data;
    }
}
