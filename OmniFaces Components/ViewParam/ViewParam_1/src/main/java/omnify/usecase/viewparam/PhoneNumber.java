package omnify.usecase.viewparam;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Constantin Alin
 */
public class PhoneNumber implements Serializable {

	private static final long serialVersionUID = 1L;

	private String areacode;
	private String exchange;
	private String subscriber;

	public PhoneNumber(String areacode, String exchange, String subscriber) {
		this.areacode = areacode;
		this.exchange = exchange;
		this.subscriber = subscriber;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 43 * hash + Objects.hashCode(this.areacode);
		hash = 43 * hash + Objects.hashCode(this.exchange);
		hash = 43 * hash + Objects.hashCode(this.subscriber);
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
		final PhoneNumber other = (PhoneNumber) obj;
		if (!Objects.equals(this.areacode, other.areacode)) {
			return false;
		}
		if (!Objects.equals(this.exchange, other.exchange)) {
			return false;
		}
		if (!Objects.equals(this.subscriber, other.subscriber)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PhoneNumber{" + "areacode=" + areacode + ", exchange=" + exchange + ", subscriber=" + subscriber + '}';
	}

}
