package oJsfLabelMessageInterpolator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;

/**
 *
 * @author Constantin Alin
 */
@Named
@RequestScoped
public class DataBean {

	@Size(min = 2, max = 25)
	private String name;
	@Size(min = 2, max = 25)
	private String surname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
