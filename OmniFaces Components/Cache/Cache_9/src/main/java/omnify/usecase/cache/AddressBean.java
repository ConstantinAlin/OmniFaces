package omnify.usecase.cache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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

	private List<String> addresses = new ArrayList<>(Arrays
			.asList(new String[] { "Monte-Carlo, Monaco", "Bottmingen, Switzerland", "Manacor, Mallorca, Spain" }));
	private String selectedAddress = "";

	private final boolean nocache = true;

	public boolean isNocache() {
		return nocache;
	}

	public AddressBean() {
		Collections.shuffle(addresses, new Random(System.nanoTime()));
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	public String getSelectedAddress() {
		return selectedAddress;
	}

	public void setSelectedAddress(String selectedAddress) {
		this.selectedAddress = selectedAddress;
	}

	public void selectAddress(String address) {
		this.selectedAddress = address;
	}

	public String getCacheContent(String key) {
		String cacheContent = CacheFactory.getCache(getContext(), "session").get(key);
		return cacheContent == null ? "null" : cacheContent;
	}

	public String getCacheELContent(String key, String name) {
		Object cacheELContent = CacheFactory.getCache(getContext(), "session").getAttribute(key, name);
		return cacheELContent == null ? "null" : cacheELContent.toString();
	}

}
