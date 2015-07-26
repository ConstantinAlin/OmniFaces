package usecase.viewparam;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.ExternalContextWrapper;

/**
 *
 * @author Constantin Alin
 */
public class CustomExternalContext extends ExternalContextWrapper {

	private ExternalContext externalContext;
	private static final Logger LOG = Logger.getLogger(CustomExternalContext.class.getName());

	public CustomExternalContext(ExternalContext externalContext) {
		this.externalContext = externalContext;
	}

	@Override
	public String encodeRedirectURL(String baseUrl, Map<String, List<String>> parameters) {
		LOG.info("Remove empty parameters - encodeRedirectURL");
		removeEmptyParameters(parameters);
		return super.encodeRedirectURL(baseUrl, parameters);
	}

	@Override
	public String encodeBookmarkableURL(String baseUrl, Map<String, List<String>> parameters) {
		LOG.info("Remove empty parameters - encodeBookmarkableURL");
		removeEmptyParameters(parameters);
		return super.encodeBookmarkableURL(baseUrl, parameters);
	}

	private void removeEmptyParameters(Map<String, List<String>> parameters) {
		Iterator<Map.Entry<String, List<String>>> iter = parameters.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, List<String>> entry = iter.next();
			if (entry.getValue().get(0).isEmpty()) {
				iter.remove();
			}
		}
	}

	@Override
	public ExternalContext getWrapped() {
		return externalContext;
	}

}
