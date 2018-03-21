/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.constraint;

import app.validator.FuckUrlValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * @author maxcess since 2018/3/16
 * @e-mail mabin@dxy.cn
 */


@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
//指定验证器
@Constraint(validatedBy = {FuckUrlValidator.class})
@Documented
public @interface FuckUrl {
    //默认错误消息
    String message() default "不能包含fuck";

    //分组
    Class<?>[] groups() default { };

    //负载
    Class<? extends Payload>[] payload() default { };

    //指定多个时使用
    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        FuckUrl [] value();
    }
}
