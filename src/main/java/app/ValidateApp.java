/*
 *Copyright © 2007-2018 DXY All Rights Reserved.
 */
package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author maxcess
 * @since 2018/2/10
 * if you have any problem  please send to mabin@dxy.cn
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ValidateApp {
    public static void main(String [] args){
        SpringApplication.run(ValidateApp.class,args);
    }

}
