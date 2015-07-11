package omnify.usecase.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Constantin Alin
 */
@Named
@RequestScoped
public class CurrencyBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> currencies;
	private int amount = 100;

	@PostConstruct
	public void init() {
		currencies = new ArrayList<>();
		currencies.addAll(Arrays.asList(new String[] { "USD", "EUR", "GBP" }));
	}

	public List<String> getCurrencies() {
		return currencies;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
