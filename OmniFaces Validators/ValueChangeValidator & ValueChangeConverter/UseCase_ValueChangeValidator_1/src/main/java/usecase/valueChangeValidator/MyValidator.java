package usecase.valueChangeValidator;

import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Constantin Alin
 */
@FacesValidator("myValidator")
public class MyValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		Object oldValue = ((EditableValueHolder) component).getValue();

		FacesMessage message = new FacesMessage();
		if (value.equals(oldValue)) {
			message.setSummary("Current value is equal with the submitted value, so no validation neeeded ...");
			message.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			Random random = new Random();
			if (random.nextInt(10) < 5) {
				message.setSummary("The validation has randomly failed. Submit again ...");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}

	}

}
