package usecase.commandscript;

import java.io.Serializable;
import java.io.StringReader;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;

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
		FacesContext context = FacesContext.getCurrentInstance();
		String params = context.getExternalContext().getRequestParameterMap().get("params");

		JsonArray paramsObj;
		try (JsonReader reader = Json.createReader(new StringReader(params))) {
			paramsObj = reader.readArray();
		}

		lastSave = new Date(System.currentTimeMillis()).toString();

		logger.log(Level.INFO, "Feedback saved at {0} !", lastSave);
		logger.log(Level.INFO, "Saved by: {0} \n Content: {1}", new Object[] {
				paramsObj.getJsonObject(0).getString("user"), paramsObj.getJsonObject(0).getString("feedback") });
	}

}
