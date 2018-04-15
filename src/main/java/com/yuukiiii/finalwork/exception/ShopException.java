package com.yuukiiii.finalwork.exception;


import com.yuukiiii.finalwork.enums.ResultEnum;

public class ShopException extends RuntimeException{
    private String code;

    public ShopException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
