package omnify.usecase.viewparam;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Constantin Alin
 */
@FacesValidator
public class PhoneNumberValidator implements Validator {

	private static final Logger LOG = Logger.getLogger(PhoneNumberValidator.class.getName());

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		LOG.log(Level.INFO, "Validator called for: {0} with value: {1}", new Object[] { component.toString(), value });

		if (value instanceof PhoneNumber == false) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
					"The phone number is not correct!");
			throw new ValidatorException(message);
		}
	}

}
