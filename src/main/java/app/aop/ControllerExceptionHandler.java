/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.aop;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * @author maxcess since 2018/3/16
 * @e-mail mabin@dxy.cn
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseBody
    public String beanvalidationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        if (!constraintViolations.isEmpty()){
            for (ConstraintViolation<?> constraintViolation : constraintViolations) {
                return  constraintViolation.getMessage();
            }
        }
        return "error";
    }



    @ExceptionHandler({BindException.class})
    @ResponseBody
    public String beanvalidationException(BindException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();
        if (!fieldErrors.isEmpty()){
            for (FieldError fieldError : fieldErrors) {
                return fieldError.getField()+":"+fieldError.getDefaultMessage();
            }
        }
        return "error";
    }
}
