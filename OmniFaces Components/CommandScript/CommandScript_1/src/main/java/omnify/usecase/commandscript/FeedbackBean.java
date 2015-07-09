package omnify.usecase.commandscript;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.omnifaces.util.Faces;

/**
 *
 * @author Constantin Alin
 */
@Named
@RequestScoped
public class FeedbackBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(FeedbackBean.class.getName());
	private String lastSave;

	public FeedbackBean() {
		// NOOP
	}

	public String getLastSave() {
		return lastSave;
	}

	public void setLastSave(String lastSave) {
		this.lastSave = lastSave;
	}

	public void send() {
		String user = Faces.getRequestParameter("user"); // user
		String feedback = Faces.getRequestParameter("feedback"); // feedback

		lastSave = new Date(System.currentTimeMillis()).toString();

		logger.log(Level.INFO, "Feedback saved at {0} !", lastSave);
		logger.log(Level.INFO, "Saved by: {0} \n Content: {1}", new String[] { user, feedback });
	}

}
