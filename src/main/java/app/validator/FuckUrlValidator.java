/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.validator;

import app.constraint.FuckUrl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author maxcess since 2018/3/16
 * @e-mail mabin@dxy.cn
 */
public class FuckUrlValidator implements ConstraintValidator<FuckUrl,String> {


    /**
     * Initializes the validator in preparation for
     * {@link #isValid(Object, ConstraintValidatorContext)} calls.
     * The constraint annotation for a given constraint declaration
     * is passed.
     * <p/>
     * This method is guaranteed to be called before any use of this instance for
     * validation.
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(FuckUrl constraintAnnotation) {
        //取一些注解上的值
    }

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     * <p/>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //验证逻辑
        if (value!=null&&value.contains("fuck")){
            return false;
        }
        return true;
    }
}
