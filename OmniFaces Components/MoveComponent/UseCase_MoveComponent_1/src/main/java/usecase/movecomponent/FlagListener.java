package usecase.movecomponent;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

/**
 *
 * @author Constantin Alin
 */
public class FlagListener implements SystemEventListener {

	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {

		UIViewRoot uiViewRoot = FacesContext.getCurrentInstance().getViewRoot();

		UIComponent redDiv = uiViewRoot.findComponent("redDiv");
		UIComponent flagId = uiViewRoot.findComponent("flagId");

		if ((redDiv != null) && (flagId != null)) {
			flagId.getChildren().add(0, redDiv);
		}
	}

	@Override
	public boolean isListenerForSource(Object source) {
		return (source instanceof UIViewRoot);
	}
}
