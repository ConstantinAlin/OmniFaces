package usecase.commandscript;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

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
	private String user;
	private String feedback;

	public FeedbackBean() {
		// NOOP
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getLastSave() {
		return lastSave;
	}

	public void setLastSave(String lastSave) {
		this.lastSave = lastSave;
	}

	public void send() {
		logger.log(Level.INFO, "User: {0}", user);
		logger.log(Level.INFO, "Feedback: {0}", feedback);

		lastSave = new Date(System.currentTimeMillis()).toString();
	}

}
