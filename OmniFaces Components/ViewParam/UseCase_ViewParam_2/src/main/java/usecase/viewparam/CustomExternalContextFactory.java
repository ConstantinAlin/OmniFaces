package usecase.viewparam;

import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.ExternalContextFactory;

/**
 *
 * @author Constantin Alin
 */
public class CustomExternalContextFactory extends ExternalContextFactory {

	private ExternalContextFactory externalContextFactory;

	public CustomExternalContextFactory() {
	}

	public CustomExternalContextFactory(ExternalContextFactory externalContextFactory) {
		this.externalContextFactory = externalContextFactory;
	}

	@Override
	public ExternalContext getExternalContext(Object context, Object request, Object response) throws FacesException {

		ExternalContext handler = new CustomExternalContext(
				externalContextFactory.getExternalContext(context, request, response));
		return handler;
	}

}
