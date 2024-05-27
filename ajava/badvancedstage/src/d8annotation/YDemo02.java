package d8annotation;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;

/**
 * @Description:
 * @Author Eva
 * @Date 2023/2/15 11:00 -> 2024/5/27 17:01
 */

@Target(value = {FIELD,TYPE,TYPE_PARAMETER,TYPE_USE})
public @interface YDemo02 {
    DAnnotation8[] value();
}
