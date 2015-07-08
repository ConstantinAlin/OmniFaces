package omnify.usecase.validateBean;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Constantin Alin
 */
@Constraint(validatedBy = { ContactValidator.class })
@Documented
@Target({ TYPE, METHOD, FIELD })
@Retention(RUNTIME)
public @interface ValidContact {

	String message() default "Invalid contact !";

	Class<?>[]groups() default {};

	Class<? extends Payload>[]payload() default {};
}
