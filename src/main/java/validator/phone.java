package validator;

/**
 * 定义自己的Annotation Validator:
 * 	定义自己的限制类型首先我们得定义一个该种限制类型的注解，而且该注解需要使用@Constraint标注。
 * 
 */

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
//@Constraint注解的validatedBy属性用于指定我们定义的当前限制类型需要被哪个ConstraintValidator进行校验
@Constraint(validatedBy = PhoneValidator.class)
public @interface phone {
	String message() default "{phone_number.not.empty}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
