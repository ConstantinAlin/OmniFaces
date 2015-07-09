package usecase.validateUniqueColumn;

import java.util.ArrayList;
import java.util.List;
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
@FacesValidator("playerUniqueValidator")
public class PlayerUniqueValidator implements Validator {

	private final List<Object> stack = new ArrayList<>();

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		if (!stack.contains(value)) {
			stack.add(value);
		} else {
			stack.clear();
			FacesMessage message = new FacesMessage();
			message.setDetail("Duplicate value! #" + value);
			message.setSummary("Duplicate value! #" + value);
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
}
