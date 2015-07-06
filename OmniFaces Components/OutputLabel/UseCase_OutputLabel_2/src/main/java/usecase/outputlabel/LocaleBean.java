package usecase.outputlabel;

import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Constantin Alin
 */
@Named
@RequestScoped
public class LocaleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public void setCurrentLocale(String locale) {
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		viewRoot.setLocale(new Locale(locale));
	}

}
