/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.validator;

import app.constraint.CheckPassword;
import app.model.Password;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author maxcess since 2018/3/16
 * @e-mail mabin@dxy.cn
 */
public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Password> {
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
    public void initialize(CheckPassword constraintAnnotation) {

    }

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     * <p/>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param pwd   object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(Password pwd, ConstraintValidatorContext context) {
        if (pwd == null) {
            return true;
        }
        //其中我们通过disableDefaultConstraintViolation禁用默认的约束；
        // 然后通过buildConstraintViolationWithTemplate(消息模板)/addPropertyNode(所属属性)/addConstraintViolation定义我们自己的约束。
        //没有填密码
        if (!StringUtils.hasText(pwd.getPwd1())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("密码1为空")
                    .addPropertyNode("pwd1")
                    .addConstraintViolation();
            return false;
        }

        if (!StringUtils.hasText(pwd.getPwd2())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("密码2为空")
                    .addPropertyNode("pwd2")
                    .addConstraintViolation();
            return false;
        }

        //两次密码不一样
        if (!pwd.getPwd1().trim().equals(pwd.getPwd2().trim())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("两次密码不一致")
                    .addPropertyNode("pwd2")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

}
