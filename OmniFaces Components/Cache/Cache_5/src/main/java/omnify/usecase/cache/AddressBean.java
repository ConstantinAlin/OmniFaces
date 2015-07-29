package omnify.usecase.cache;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Constantin Alin
 */
@Named
@ViewScoped
public class AddressBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean disabled;
	private List<String> addresses = new ArrayList<>();
	private static final String[] addressesArray = new String[] { "Monte-Carlo, Monaco", "Bottmingen, Switzerland",
			"Manacor, Mallorca, Spain", "St. Barthelemy, Switzerland", "Bradenton, Florida, USA", "London, England",
			"Jurmala, Latvia", "Delray Beach, FL, USA / Johann", "Neuchatel, Switzerland", "La Roda (Albacete), Spain",
			"Salto, R. Oriental del Uruguay", "Madrid, Spain", "Liege, Belgium", "Canberra and Melbourne, Austra",
			"Astana, Kazakhstan" };

	public AddressBean() {
		add();
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public void generateAddress() throws ParseException {
		add();
	}

	private void add() {
		disabled = new Random().nextInt() % 2 == 0;
		addresses.add(addressesArray[new Random().nextInt(addressesArray.length)]);
	}
}
