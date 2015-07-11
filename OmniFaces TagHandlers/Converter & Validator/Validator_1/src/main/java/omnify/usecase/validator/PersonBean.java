package omnify.usecase.validator;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Constantin Alin
 */
@Named
@SessionScoped
public class PersonBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Person> persons;

	@PostConstruct
	public void init() {
		persons = Arrays.asList(new Person("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", "mike@gmail.com", "E-mail"),
				new Person("^\\+(?:[0-9] ?){6,14}[0-9]$", "+1 1234567890123", "Phone Number"),
				new Person("^[0-9]{5}(?:-[0-9]{4})?$", "12345-4423", "Zip Code"),
				new Person("^[a-zA-Z\\\\s]+", "MikeTorn", "Full Name"));
	}

	public List<Person> getPersons() {
		return persons;
	}
}
