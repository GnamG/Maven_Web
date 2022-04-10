package com.fc.advice;

import com.fc.vo.ResultVo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    // 对指定的异常进行捕获
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public ResultVo handleDuplicateKeyException(DuplicateKeyException e){
        return new ResultVo("当前用户名已存在",4000,false,e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultVo handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
        return new ResultVo("请输入Json方式的参数",4100,false,e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultVo handleMissingServletRequestParameterException(MissingServletRequestParameterException e){
        return new ResultVo("缺少了必要的参数",4200,false,e.getMessage());
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultVo handleRuntimeException(RuntimeException e){
        return new ResultVo("您的操作有误",4040,false,e.getMessage());
    }
}
