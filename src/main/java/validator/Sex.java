package validator;

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
@Constraint(validatedBy = SexValidator.class)
public @interface Sex {
	
	//message(),groups(),payload()这三个参数必须有，否则报错
	String message() default "{sex.not.illegal}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
	
}
