package com.example.demo.bean.security;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Sunny
 * @create 2021/2/2
 */
@Data
public class ResponseBase implements Serializable {

    private static final long serialVersionUID = 1L;
    //返回值
    private String code;
    //返回信息
    private String message;
    //返回内容
    private Object bizContent;
    //时间戳
    private String timestamp;

    //签文
    private String signValue;


}

