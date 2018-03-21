/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.constraint;

import app.validator.CrossParameterValidator;

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
@Constraint(validatedBy = CrossParameterValidator.class)
@Target({ METHOD, CONSTRUCTOR, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface CrossParameter {

    String message() default "两次密码不一致";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}