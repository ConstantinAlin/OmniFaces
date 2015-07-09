package omnify.usecase.valueChangeValidator;

import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;
import org.omnifaces.validator.ValueChangeValidator;

/**
 *
 * @author Constantin Alin
 */
@FacesValidator("myValidator")
public class MyValidator extends ValueChangeValidator {

	@Override
	public void validateChangedObject(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
		FacesMessage message_info = new FacesMessage();
		message_info.setSummary("Current value is not equal with the submitted value, so validation neeeded ...");
		message_info.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, message_info);
		Random random = new Random();
		if (random.nextInt(10) < 5) {
			FacesMessage message_err = new FacesMessage();
			message_err.setSummary("The validation has randomly failed. Submit again ...");
			message_err.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message_err);
		}
	}
}
