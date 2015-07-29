package usecase.param;

import java.io.Serializable;
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

	private PhoneNumber number;

	public DataBean() {
	}

	public PhoneNumber getNumber() {
		return number;
	}

	public void setNumber(PhoneNumber number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.number);
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
		if (!Objects.equals(this.number, other.number)) {
			return false;
		}
		return true;
	}
}
