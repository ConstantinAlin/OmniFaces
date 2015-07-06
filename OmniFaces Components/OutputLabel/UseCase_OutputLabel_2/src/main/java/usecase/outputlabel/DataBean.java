package usecase.outputlabel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Constantin Alin
 */
@Named
@RequestScoped
public class DataBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String surname;
	private String city;
	private String zipcode;
	private String address;
	private String email;
	private String state;
	private static final List<String> countries = new ArrayList<>();

	static {
		countries.add("USA");
		countries.add("France");
	}

	public DataBean() {
		// NOOP
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<String> getCountries() {
		return countries;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 19 * hash + Objects.hashCode(this.name);
		hash = 19 * hash + Objects.hashCode(this.surname);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final DataBean other = (DataBean) obj;
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (!Objects.equals(this.surname, other.surname)) {
			return false;
		}
		return true;
	}

}
