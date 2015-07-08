package omnify.usecase.selectItemsConverter;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Constantin Alin
 */
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String residence;
	private int age;

	public Player(Long id, String name, String residence, int age) {
		this.id = id;
		this.name = name;
		this.residence = residence;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 53 * hash + Objects.hashCode(this.id);
		hash = 53 * hash + Objects.hashCode(this.name);
		hash = 53 * hash + Objects.hashCode(this.residence);
		hash = 53 * hash + this.age;
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
		final Player other = (Player) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (!Objects.equals(this.residence, other.residence)) {
			return false;
		}
		if (this.age != other.age) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return id + "," + name + "," + residence + "," + age;
	}
}
