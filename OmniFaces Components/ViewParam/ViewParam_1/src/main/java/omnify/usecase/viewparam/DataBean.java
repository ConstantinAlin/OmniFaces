package omnify.usecase.viewparam;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Constantin Alin
 */
@Named
@ViewScoped
public class DataBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(DataBean.class.getName());

	public DataBean() {
		// NOOP
	}

	private String name;
	private String surname;
	private PhoneNumber phone;
	private String payment;
	private int cost;

	public void init() {
		// <f:event type="preRenderView" listener="#{dataBean.init()}"/>
		/*
		 * if (!FacesContext.getCurrentInstance().isPostback()) { LOG.info(
		 * "Initialization stuff ..."); cost = 0; }
		 */

		// for <f:viewAction action="#{dataBean.init()}"/>
		LOG.info("Initialization stuff ...");
		cost = 0;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		LOG.info("Setter for 'payment' called ...");
		this.payment = payment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		LOG.info("Setter for 'name' called ...");
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		LOG.info("Setter for 'surname' called ...");
		this.surname = surname;
	}

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		LOG.info("Setter for 'phone' called ...");
		this.phone = phone;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		LOG.info("Setter for 'cost' called ...");
		this.cost = cost;
	}

	public void computePingCost() {
		cost = cost + 10 + new Random().nextInt(100);
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 71 * hash + Objects.hashCode(this.name);
		hash = 71 * hash + Objects.hashCode(this.surname);
		hash = 71 * hash + Objects.hashCode(this.phone);
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
		if (!Objects.equals(this.phone, other.phone)) {
			return false;
		}
		return true;
	}

}
