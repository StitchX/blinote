package d13reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

/**
 * @Description:
 * @Author Eva
 * @Date 2024/6/4 21:34
 */

@Target(value = {FIELD,TYPE,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface YMyAnnotation {
    String[] value() default "hello";
}
