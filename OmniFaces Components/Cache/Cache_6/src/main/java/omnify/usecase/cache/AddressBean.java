package omnify.usecase.cache;

import java.io.Serializable;
import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.omnifaces.component.output.cache.CacheFactory;
import static org.omnifaces.util.Faces.getContext;

/**
 *
 * @author Constantin Alin
 */
@Named
@RequestScoped
public class AddressBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String[] addressesArray = new String[] { "Monte-Carlo, Monaco", "Bottmingen, Switzerland",
			"Manacor, Mallorca, Spain", "St. Barthelemy, Switzerland", "Bradenton, Florida, USA", "London, England",
			"Jurmala, Latvia", "Delray Beach, FL, USA / Johann", "Neuchatel, Switzerland", "La Roda (Albacete), Spain",
			"Salto, R. Oriental del Uruguay", "Madrid, Spain", "Liege, Belgium", "Canberra and Melbourne, Austra",
			"Astana, Kazakhstan" };

	public AddressBean() {
	}

	public String generateAddress() {
		return addressesArray[new Random().nextInt(addressesArray.length)];
	}

	public String checkCache(String address) {
		return CacheFactory.getCache(getContext(), "session").get(address) == null ? "blue" : "red";
	}

}
