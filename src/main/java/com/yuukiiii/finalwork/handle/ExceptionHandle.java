package com.yuukiiii.finalwork.handle;


import com.yuukiiii.finalwork.exception.ShopException;
import com.yuukiiii.finalwork.model.Result;
import com.yuukiiii.finalwork.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof ShopException){
            ShopException shopException = (ShopException) e;
            return ResultUtil.Error(shopException.getCode(),shopException.getMessage());
        }
        return ResultUtil.Error("2000",e.getMessage());
    }
}
