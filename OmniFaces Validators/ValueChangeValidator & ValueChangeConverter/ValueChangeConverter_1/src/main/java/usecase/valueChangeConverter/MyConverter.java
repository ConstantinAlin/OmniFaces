package usecase.valueChangeConverter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.omnifaces.converter.ValueChangeConverter;

/**
 *
 * @author Constantin Alin
 */
@FacesConverter("myConverter")
public class MyConverter extends ValueChangeConverter {

	@Override
	public Object getAsChangedObject(FacesContext fc, UIComponent uic, String string) {
		FacesMessage message_info = new FacesMessage();
		message_info.setSummary("Current value must be converted ...");
		message_info.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, message_info);

		return string.toUpperCase();
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return String.valueOf(value).toLowerCase();
	}

}
