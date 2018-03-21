/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.controller;

import app.constraint.CrossParameter;
import app.constraint.FuckUrl;
import app.group.Add;
import app.group.First;
import app.group.Update;
import app.model.*;
import app.service.PasswordService;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.util.Set;

/**
 * @author maxcess
 * @since 2018/2/10
 * if you have any problem  please send to mabin@dxy.cn
 */
@RestController
@Validated
public class UserController {
    @GetMapping("/user/info")
    public Result get(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                return Result.error(fieldError.getField() + ":" + "【" + fieldError.getRejectedValue() + "】" + fieldError.getDefaultMessage());
            }

        }
        user.setAge(10);
        user.setPhone("13355556666");
        return Result.data("用户信息", user);
    }

    @RequestMapping("/user/add")
    public Result add(@Validated({Add.class, Default.class}) UserGroup user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                return Result.error(fieldError.getField() + ":" + fieldError.getDefaultMessage());
            }

        }
        return Result.data("success", user);
    }

    @RequestMapping("/user/update")
    public Result update(@Validated(Update.class) UserGroup user, BindingResult bindingResult) {

        return Result.data("success", user);
    }

    @RequestMapping("/user/group-sequence")
    public Result groupSequence(@Validated UserGroupSequence user, BindingResult bindingResult) {
        return Result.data("success", user);
    }

    @RequestMapping("/user/cascade")
    public Result cascade(@RequestBody @Validated(First.class) UserCascade user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String messege = "";
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                messege += fieldError.getField() + ":" + fieldError.getDefaultMessage() + "\n";
            }
            return Result.error(messege);
        }
        return Result.data("suceess", user);
    }

    /**
     * 方法及返回值参数验证 需要MethodValidationPostProcessor 支持
     * @param uid
     * @return
     */
    @RequestMapping("/user/method")
    public @NotBlank(message = "返回结果不能为空") String method(@NotNull(message = "uid不能为空") Integer uid) {
        if (uid < 5) {
            return "";
        }
        return "success";
    }

    @RequestMapping("/user/myValidator")
    public String myValidator(@FuckUrl String url) {
        return "success";
    }

    @RequestMapping("/user/classValidator")
    public Result classValidator(@Validated Password pwd, BindingResult result) {
        return Result.data("succeess", pwd);
    }

    /**
     * 方法级别跨参数验证
     * 过@Validated注解表示该类中有需要进行方法参数/返回值验证 @CrossParameter注解方法表示要进行跨参数验证；即验证pwd1和pwd2是否相等。
     *
     * @param pwd1
     * @param pwd2
     * @return
     */
    @RequestMapping("/user/crossParamsValidator")
    @CrossParameter
    public String crossParamsValidator(String pwd1, String pwd2) {
        return "sucess";
    }

    @Autowired
    private PasswordService passwordService;

    @RequestMapping("/user/changePwd")
    public String changePwd(String pwd1, String pwd2) {
        passwordService.changePassword(pwd1, pwd2);
        return "sucess";
    }

    @RequestMapping("/user/scriptValidator")
    public Result scriptValidator(@Validated ScriptPassword pwd, BindingResult result) {
        if (result.hasGlobalErrors()) {
            return Result.error(result.getGlobalError().getDefaultMessage());
        }
        return Result.data("success", pwd);
    }

    @Autowired
    Validator globalValidator;

    @RequestMapping("/validate")
    public String validate1() {
        User foo = new User();
        foo.setAge(2);
        Set<ConstraintViolation<User>> set = globalValidator.validate(foo);
        for (ConstraintViolation<User> constraintViolation : set) {
            return constraintViolation.getInvalidValue() + "：" + constraintViolation.getMessage();
        }
        return "success";
    }


    @RequestMapping("/validate2")
    public String validate2() {
        User foo = new User();
        foo.setAge(2);
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<User>> set = validator.validate(foo);
        for (ConstraintViolation<User> constraintViolation : set) {
            return constraintViolation.getInvalidValue() + "：" + constraintViolation.getMessage();
        }
        return "success";
    }
}
