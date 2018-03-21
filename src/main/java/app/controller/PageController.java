/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author maxcess since 2018/3/8
 * @e-mail mabin@dxy.cn
 */
@Controller
public class PageController {
    @RequestMapping("/user.htm")
    public String user() {
        System.out.println("html页面");
        return "user";
    }
}
