package omnify.usecase.movecomponent;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

/**
 *
 * @author Constantin Alin
 */
@Named
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(LoginBean.class.getName());

	private String email;
	private String password;
	private String info = "not login";

	public void loginAction() {
		LOG.info("LoginBean#loginAction() ...........");
		info = "successfully login";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
