package usecase.highlight;

import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.omnifaces.util.Components;

/**
 *
 * @author Constantin Alin
 */
public class PhaseInputValidationListener implements PhaseListener {

	String componentIdsJSON = "";

	@Override
	public void afterPhase(PhaseEvent pe) {
		if (pe.getFacesContext().isValidationFailed()) {
			componentIdsJSON = "[";

			UIForm submittedForm = Components.getCurrentForm();
			processComponents(submittedForm);

			componentIdsJSON = componentIdsJSON.substring(0, componentIdsJSON.length() - 1) + "]";

			pe.getFacesContext().getAttributes().put("componentIdsJSON", componentIdsJSON);
		}
	}

	@Override
	public void beforePhase(PhaseEvent pe) {
		// NOOP
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.PROCESS_VALIDATIONS;
	}

	private void processComponents(UIComponent root) {

		for (UIComponent child : root.getChildren()) {
			if (child instanceof UIInput) {
				UIInput inputSource = (UIInput) child;

				if (!inputSource.isValid()) {
					componentIdsJSON = componentIdsJSON + "{\"cid\":\"" + inputSource.getClientId() + "\"},";
				}
			} else {
				processComponents(child);
			}
		}
	}
}
