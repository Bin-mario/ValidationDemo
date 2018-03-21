/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.validator;

import app.constraint.CrossParameter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

/**
 * @author maxcess since 2018/3/16
 * @e-mail mabin@dxy.cn
 * 其中@SupportedValidationTarget(ValidationTarget.PARAMETERS)表示验证参数； value将是参数列表。
 */
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class CrossParameterValidator implements ConstraintValidator<CrossParameter, Object[]> {

    @Override
    public void initialize(CrossParameter constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        if(value == null || value.length != 2) {
            throw new IllegalArgumentException("must have two args");
        }
        if(value[0] == null || value[1] == null) {
            return false;
        }
        if(value[0].equals(value[1])) {
            return true;
        }
        return false;
    }
}