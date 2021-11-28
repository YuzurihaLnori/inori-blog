package inori.blog.annotion;

import java.lang.annotation.*;

/**
 * 日志注解
 *
 * @author Inori
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AccessLog {

    /**
     * 访问内容
     */
    String value() default "";


}
