/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.aop;

import app.model.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * @author maxcess since 2018/3/16
 * @e-mail mabin@dxy.cn
 */
@Component
@Aspect
public class BindResultHandler {
    //环绕通知,环绕增强，相当于MethodInterceptor
    @Around("execution(* app.controller..*.*(..))")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("方法环绕start.....");
        Object[] objects = pjp.getArgs();
        //取参数，如果没参数，那肯定不校验了
        if (objects.length == 0) {
            return pjp.proceed();
        }

        /**************************校验封装好的javabean**********************/
        //寻找带BindingResult参数的方法，然后判断是否有error，如果有则是校验不通过
        for (Object object : objects) {
            if (object instanceof BindingResult) {
                //有校验
                BindingResult result = (BindingResult) object;
                if (result.hasErrors()) {
                    List<FieldError> list = result.getFieldErrors();
                    for (FieldError error : list) {
                        System.out.println(error.getField() + "---" + error.getRejectedValue() + "--" + error.getDefaultMessage());
                        //返回第一条校验失败信息。也可以拼接起来返回所有的
                        return Result.error(error.getDefaultMessage());
                    }
                }
            }
        }

        return pjp.proceed(objects);
    }
}