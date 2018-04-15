package com.yuukiiii.finalwork.enums;

/**
 * Created by Yuukiiii
 * on 2018/4/11 20:30
 */


public enum OrderEnum {
    SHOPPING_CART("1","购物车"),
    ORDER("2","已下单"),
    PAID("3","已支付"),
    CANCEL("4","已取消"),

    ;

    private String code;
    private String status;

    OrderEnum(String code, String status) {
        this.code = code;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }
}
